package com.example.demo.Service;

import org.springframework.stereotype.Service;

import com.example.demo.Classes.book;
import com.example.demo.Repository.BookRepository;

@Service 
public class BookService {
    
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Integer addNewBook(String author, String title, String genre, Double price, String publish_date, String description) {
        book newBook = new book(author, title, genre, price, publish_date, description);
        bookRepository.save(newBook);
        return newBook.getId();
    }
    public book getBookById(Integer id) {
        return bookRepository.findById(id).orElse(null);
    }

    public void deleteBookById(Integer id) {
        bookRepository.deleteById(id);
    }
    
}
