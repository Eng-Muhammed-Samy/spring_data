package com.example.demo.controller;

import com.example.demo.model.ProductModel;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {
    @Autowired ProductService productService;

    @PostMapping
    void addNewProduct(@RequestBody ProductModel productModel){
        productService.create(productModel);
    }

    @PutMapping
    void updateProduct(@RequestBody ProductModel productModel){
        productService.update(productModel);
    }

    @GetMapping
    List<ProductModel> list(){
        return productService.findAll();
    }

    @DeleteMapping("{name}")
    void deleteByName(@PathVariable String name){
        productService.delete(name);
    }

    @GetMapping("{id}/{name}")
    ProductModel findProduct(@PathVariable Long id, @PathVariable String name){
        return productService.findByIdAndName(id, name);
    }
}
