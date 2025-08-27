package com.example.booksapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.booksapi.entities.Book;
import com.example.booksapi.repositories.BookRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class BookService {
    
 @Autowired
    private BookRepository repository;

    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    public Book getBookById(Long id) {
        return repository.findById(id)
                         .orElseThrow(() -> new EntityNotFoundException("Livro não encontrado"));
    }

    public Book saveBook(Book book) {
        return repository.save(book);
    }

    public void updateBook(Book book, Long id) {
        Book aux = repository.getReferenceById(id);
        aux.setTitle(book.getTitle());
        aux.setAuthor(book.getAuthor());
        aux.setPrice(book.getPrice());
        aux.setYear(book.getYear());

        repository.save(aux);
    }

    public void deleteBook(Long id) {
        if(repository.existsById(id))
            repository.deleteById(id);
        else
            throw new EntityNotFoundException("Livro não existe");
    }  

}
