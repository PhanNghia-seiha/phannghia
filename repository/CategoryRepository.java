package com.example.asm2java202.repository;

import com.example.asm2java202.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, String> {
}
