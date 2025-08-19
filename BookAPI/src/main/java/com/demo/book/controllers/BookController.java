package com.demo.book.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.demo.book.models.Book;
import com.demo.book.services.BookService;



@Controller
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        Book book = bookService.findBook(id);
        model.addAttribute("book", book);
        return "show";
    }
}
