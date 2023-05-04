package com.example.demo.repository;

import com.example.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findByName(String name);

    Product findByIdAndName(Long id, String name);

    @Query("DELETE FROM Product p where p.name =?1")
    void deleteProductByName(String name);
}
