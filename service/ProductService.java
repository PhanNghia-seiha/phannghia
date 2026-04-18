package com.example.asm2java202.service;

import com.example.asm2java202.entity.Product;

import java.util.List;

public interface ProductService {
    Product create(Product product);

    Product update(Product product);

    void delete(Integer id);

    List<Product> findAll();

    Product findById(Integer id);

    List<Product> findByCategory(String id);

    List<Product> search(String keyword);

    List<Product> sortAsc();

    List<Product> sortDesc();

    List<Product> searchAndSortAsc(String keyword);

    List<Product> searchAndSortDesc(String keyword);
}
