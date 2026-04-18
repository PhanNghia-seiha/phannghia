package com.example.asm2java202.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Report {
    private String category;
    private Double revenue;
    private Long quantity;
    private Double maxPrice;
    private Double minPrice;
    private Double avgPrice;
}
