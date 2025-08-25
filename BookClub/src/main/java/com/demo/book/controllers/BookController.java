package com.demo.book.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.book.models.Book;
import com.demo.book.models.User;
import com.demo.book.services.BookService;
import com.demo.book.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;
    private final UserService userService;

    public BookController(BookService bookService, UserService userService){
        this.bookService = bookService;
        this.userService = userService;
    }

    @GetMapping
    public String books(Model model, HttpSession session){
        Long uid = (Long) session.getAttribute("userId");
        if(uid == null) return "redirect:/";
        User me = userService.findById(uid);
        List<Book> books = bookService.all();
        model.addAttribute("me", me);
        model.addAttribute("books", books);
        return "books";
    }

    @GetMapping("/new")
    public String newBook(@ModelAttribute("book") Book book,
                          HttpSession session, Model model){
        if(session.getAttribute("userId")==null) return "redirect:/";
        return "new";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("book") Book book,
                         BindingResult result, HttpSession session, Model model){
        Long uid = (Long) session.getAttribute("userId");
        if(uid == null) return "redirect:/";
        if(result.hasErrors()){
            return "new";
        }
        User poster = userService.findById(uid);
        book.setPoster(poster);
        bookService.create(book);
        return "redirect:/books";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable Long id, HttpSession session, Model model){
        Long uid = (Long) session.getAttribute("userId");
        if(uid == null) return "redirect:/";
        Book book = bookService.find(id);
        model.addAttribute("book", book);
        model.addAttribute("uid", uid);
        return "show";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Long id, HttpSession session, Model model){
        Long uid = (Long) session.getAttribute("userId");
        if(uid == null) return "redirect:/";
        Book book = bookService.find(id);
        if(book==null || !book.getPoster().getId().equals(uid)) return "redirect:/books";
        model.addAttribute("book", book);
        return "edit";
    }

    @PostMapping("/{id}/update")
    public String update(@PathVariable Long id,
                         @Valid @ModelAttribute("book") Book book,
                         BindingResult result,
                         HttpSession session){
        Long uid = (Long) session.getAttribute("userId");
        if(uid == null) return "redirect:/";
        if(result.hasErrors()){
            return "edit";
        }
        Book existing = bookService.find(id);
        if(existing==null || !existing.getPoster().getId().equals(uid)) return "redirect:/books";
        book.setId(id);
        book.setPoster(existing.getPoster());
        bookService.update(book);
        return "redirect:/books/" + id;
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id, HttpSession session){
        Long uid = (Long) session.getAttribute("userId");
        if(uid == null) return "redirect:/";
        Book b = bookService.find(id);
        if(b!=null && b.getPoster().getId().equals(uid)){
            bookService.delete(id);
        }
        return "redirect:/books";
    }
}