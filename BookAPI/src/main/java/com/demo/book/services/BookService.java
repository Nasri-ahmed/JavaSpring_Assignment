package com.demo.book.services;

import org.springframework.stereotype.Service;
import com.demo.book.models.Book;
import com.demo.book.repositories.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public List<Book> allBooks() {
        return bookRepository.findAll();
    }

    public Book createBook(Book b) {
        return bookRepository.save(b);
    }

    public Book findBook(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public Book updateBook(Long id, Book updatedBook) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()){
            Book book = optionalBook.get();
            book.setTitle(updatedBook.getTitle());
            book.setDescription(updatedBook.getDescription());
            book.setLanguage(updatedBook.getLanguage());
            book.setNumberOfPages(updatedBook.getNumberOfPages());
            return bookRepository.save(book);
        }
        return null;
    }

    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }
}
