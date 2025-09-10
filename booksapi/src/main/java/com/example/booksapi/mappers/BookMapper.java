package com.example.booksapi.mappers;

import java.math.RoundingMode;
import java.util.List;
import java.util.Objects;

import com.example.booksapi.dtos.BookRequest;
import com.example.booksapi.dtos.BookResponse;
import com.example.booksapi.entities.Book;

public final class BookMapper {

    private BookMapper() {}

    public static Book toEntity(BookRequest req) {
        if (req == null) return null;

        Book b = new Book();
        b.setTitle(req.title());
        b.setAuthor(req.author());
        if (req.price() != null) {
            b.setPrice(req.price().setScale(2, RoundingMode.HALF_UP));
        }
        b.setYear(req.year());
        return b;
    }

    public static void updateEntity(Book entity, BookRequest req) {
        if (entity == null || req == null) return;

      
        entity.setTitle(req.title());
        entity.setAuthor(req.author());
        if (req.price() != null) {
            entity.setPrice(req.price().setScale(2, RoundingMode.HALF_UP));
        } else {
            entity.setPrice(null);
        }
        entity.setYear(req.year());
    }

    public static BookResponse toResponse(Book entity) {
        if (entity == null) return null;
        return new BookResponse(
                entity.getId(),
                entity.getTitle(),
                entity.getAuthor(),
                entity.getPrice(),
                entity.getYear()
        );
    }

    public static List<BookResponse> toResponseList(List<Book> books) {
        if (books == null) return List.of();
        return books.stream()
                .filter(Objects::nonNull)
                .map(BookMapper::toResponse)
                .toList();
    }
}
