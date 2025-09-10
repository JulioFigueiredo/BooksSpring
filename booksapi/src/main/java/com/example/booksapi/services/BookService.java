package com.example.booksapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.booksapi.dtos.BookRequest;
import com.example.booksapi.dtos.BookResponse;
import com.example.booksapi.entities.Book;
import com.example.booksapi.mappers.BookMapper;
import com.example.booksapi.repositories.BookRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    public List<BookResponse> getBooks() {
        return repository.findAll()
                .stream()
                .map(BookMapper::toResponse)
                .toList();
    }

    public BookResponse getBookById(Long id) {
        return repository.findById(id)
                .map(BookMapper::toResponse)
                .orElseThrow(() -> new EntityNotFoundException("Livro não cadastrado"));
    }

    public BookResponse saveBook(BookRequest request) {
        Book book = BookMapper.toEntity(request);
        Book saved = repository.save(book);
        return BookMapper.toResponse(saved);
    }

    public void updateBook(BookRequest request, Long id) {
        Book aux = repository.getReferenceById(id);
        BookMapper.updateEntity(aux, request);
        repository.save(aux);
    }

    public void deleteBookById(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Livro não existe");
        }
    }
}
