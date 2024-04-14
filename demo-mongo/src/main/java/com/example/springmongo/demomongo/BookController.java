package com.example.springmongo.demomongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookRepository bookRepository;


    @GetMapping(value = "/getBooks")
    public List<Books> getBook() {
        return bookRepository.findAll();
    }


    @PostMapping(value = "/insertBook")
    public void insertBook(@RequestBody CreateRequest request) {
        Books book = new Books(request.getName(),request.getAuthorName(),request.getCost());
        bookRepository.save(book);
    }


    @GetMapping("/getBookByAuthor")
    public List<Books> getBookByAuthorName(@RequestParam(value = "name") String name) {
        return bookRepository.findByAuthorName(name);
    }
}
