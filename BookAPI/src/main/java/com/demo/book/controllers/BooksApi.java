package com.demo.book.controllers;

import org.springframework.web.bind.annotation.*;
import com.demo.book.models.Book;
import com.demo.book.services.BookService;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BooksApi {

    private final BookService bookService;

    public BooksApi(BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping("")
    public List<Book> index() {
        return bookService.allBooks();
    }

    @GetMapping("/{id}")
    public Book show(@PathVariable Long id) {
        return bookService.findBook(id);
    }

    @PostMapping("")
    public Book create(@RequestBody Book book) {
        return bookService.createBook(book);
    }

    @PutMapping("/{id}")
    public Book update(@PathVariable Long id, @RequestBody Book book) {
        return bookService.updateBook(id, book);
    }

    @DeleteMapping("/{id}")
    public void destroy(@PathVariable Long id){
        bookService.deleteBook(id);
    }
}
