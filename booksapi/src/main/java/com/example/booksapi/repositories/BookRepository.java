package com.example.booksapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.booksapi.entities.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
    
}
