package com.example.booksapi.dtos;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record BookRequest (
     
    @NotBlank(message = "Title is required")
    @Size(min = 1, max = 150, message = "Title must be between 1 and 150 characters")
    String title,

    @NotBlank(message = "Author is required")
    @Size(min = 1, max = 120, message = "Author must be between 1 and 120 characters")
    String author,

    @DecimalMin(value = "0.00", inclusive = true, message = "Price must be greater than or equal to 0.00")
    @Digits(integer = 8, fraction = 2, message = "Price must have up to 8 integer digits and 2 decimal places")
    BigDecimal price,

    @Min(value = 0, message = "Year must be greater than or equal to 0")
    Integer year

){
    
}
