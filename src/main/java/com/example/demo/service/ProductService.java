package com.example.demo.service;
import com.example.demo.model.ProductModel;

import java.util.List;

public interface ProductService {
    void create(ProductModel product);
    void delete(String name);
    void update(ProductModel product);
    List<ProductModel> findAll();
    ProductModel findById(Long id);

    ProductModel findByName(String name);

    ProductModel findByIdAndName(Long id, String Name);
}
