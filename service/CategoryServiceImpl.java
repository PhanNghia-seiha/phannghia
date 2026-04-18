package com.example.asm2java202.service;

import com.example.asm2java202.entity.Category;
import com.example.asm2java202.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repo;

    @Override
    public List<Category> findAll() {
        return repo.findAll();
    }

    @Override
    public Category findById(String id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Category create(Category category) {
        return repo.save(category);
    }

    @Override
    public Category update(Category category) {
        return repo.save(category);
    }

    @Override
    public void delete(String id) {
        repo.deleteById(id);
    }
}
