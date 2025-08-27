package com.example.booksapi.entities;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String author;

    @Column(precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "publication_year")
    private Integer year;

    public Book() { }

    public Book(Long id, String title, String author, BigDecimal price, Integer year) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
        this.year = year;
    }

    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }

    public Integer getYear() { return year; }
    public void setYear(Integer year) { this.year = year; }
}
