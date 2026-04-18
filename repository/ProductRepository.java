package com.example.asm2java202.repository;

import com.example.asm2java202.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByCategory_Id(String id);
    List<Product> findByNameContainingIgnoreCase(String name);

    List<Product> findAllByOrderByPriceAsc();

    List<Product> findAllByOrderByPriceDesc();
    List<Product> findByNameContainingIgnoreCaseOrderByPriceAsc(String name);

    List<Product> findByNameContainingIgnoreCaseOrderByPriceDesc(String name);
}
