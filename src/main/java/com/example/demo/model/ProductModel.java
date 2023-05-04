package com.example.demo.model;

import lombok.Data;

@Data
public class ProductModel {
    private Long id;
    private String nameEn;
    private Double price;
    private Long quantity;
    private String description;
}
