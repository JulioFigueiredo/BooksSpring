package com.example.booksapi.dtos;

import java.math.BigDecimal;

public record BookResponse (
    Long id,
    String title,
    String author,
    BigDecimal price,
    Integer year
){
    
}
