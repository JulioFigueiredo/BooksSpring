package com.example.booksapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.booksapi.entities.Book;
import com.example.booksapi.services.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService service;

    @GetMapping
    public List<Book> getAll() {
        return service.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getById(@PathVariable Long id) {
        return service.getBookById(id);
    }

    @PostMapping
    public Book create(@RequestBody Book book) {
        return service.saveBook(book);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Book book) {
        service.updateBook(book, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteBook(id);
    }
}


