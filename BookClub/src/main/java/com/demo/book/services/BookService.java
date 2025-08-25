package com.demo.book.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.book.models.Book;
import com.demo.book.repositories.BookRepository;


@Service
public class BookService {
    private final BookRepository bookRepo;
    public BookService(BookRepository bookRepo){ this.bookRepo = bookRepo; }

    public List<Book> all(){ return bookRepo.findAll(); }
    public Book create(Book b){ return bookRepo.save(b); }
    public Book find(Long id){ return bookRepo.findById(id).orElse(null); }
    public Book update(Book b){ return bookRepo.save(b); }
    public void delete(Long id){ bookRepo.deleteById(id); }
}