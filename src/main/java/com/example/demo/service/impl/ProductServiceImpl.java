package com.example.demo.service.impl;

import com.example.demo.entity.Product;
import com.example.demo.mapper.ProductMapper;
import com.example.demo.model.ProductModel;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired private ProductRepository productRepository;
    @Autowired private ProductMapper productMapper;

    @Override
    public void create(ProductModel productModel) {
        Product product = productMapper.toEntity(productModel);
        productRepository.save(product);
        log.info("Product With Id {} Was Created", productModel.getId());
    }

    @Override
    public void delete(String name) {
        productRepository.deleteProductByName(name);
    }

    @Override
    public void update(ProductModel productModel) {
        Product product1 = productRepository.findById(productModel.getId())
                .orElseThrow(()-> new RuntimeException());
        product1.setDescription(productModel.getDescription());

        productRepository.save(product1);
    }

    @Override
    public List<ProductModel> findAll() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public ProductModel findById(Long id) {
        return productMapper.toModel(productRepository.findById(id).orElse(null));
    }

    @Override
    public ProductModel findByName(String name) {
        return productMapper.toModel(productRepository.findByName(name));
    }

    @Override
    public ProductModel findByIdAndName(Long id, String name) {
        return productMapper.toModel(productRepository.findByIdAndName(id, name));
    }
}
