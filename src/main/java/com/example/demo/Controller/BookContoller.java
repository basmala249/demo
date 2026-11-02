package com.example.demo.Controller;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Classes.book;
import com.example.demo.Service.BookService;
import com.github.cliftonlabs.json_simple.JsonException;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

@RestController
public class BookContoller {
    private final BookService bookService;


    public BookContoller(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello";
    }

    @PostMapping("/addBook")
    public String addBook(@RequestBody book newBook){
        // Call the service to add the book
        Integer newBookId = bookService.addNewBook(newBook.getAuthor(), newBook.getTitle(), newBook.getGenre(), newBook.getPrice(), newBook.getPublish_date(), newBook.getDescription());

        return "Book added with ID: " + newBookId + " " + newBook.getTitle() + " by " + newBook.getAuthor();
    }
    @GetMapping("/getBook")
    public String getBook(@RequestParam Integer id){
        // Call the service to get the book by ID
        var book = bookService.getBookById(id);
        if (book != null) {
            return "Book found: " + book.getTitle() + " by " + book.getAuthor();
        } else {
            return "Book not found with ID: " + id;
        }
    }

    @DeleteMapping("/deleteBook")
    public String deleteBook(@RequestParam Integer id){
        // Call the service to delete the book by ID
        bookService.deleteBookById(id);
        return "Book deleted with ID: " + id;
    }

    @PostMapping("/addJsonBook")
    public String addJsonBook(@RequestPart("file") MultipartFile file) throws JsonException, IOException{
        Reader reader = Files.newBufferedReader(Paths.get(file.getOriginalFilename()));
        JsonObject parser = (JsonObject) Jsoner.deserialize(reader);
        book newBook = new book(parser.get("author").toString(), parser.get("title").toString(), parser.get("genre").toString(), Double.parseDouble(parser.get("price").toString()), parser.get("publish_date").toString(), parser.get("description").toString());
        Integer newBookId = bookService.addNewBook(newBook.getAuthor(), newBook.getTitle(), newBook.getGenre(), newBook.getPrice(), newBook.getPublish_date(), newBook.getDescription());
        return "Book added with ID: " + newBookId + " " + newBook.getAuthor() + " " + newBook.getTitle() + " " + newBook.getGenre() + " " + newBook.getPrice() + " " + newBook.getPublish_date() + " " + newBook.getDescription();
    }
}
