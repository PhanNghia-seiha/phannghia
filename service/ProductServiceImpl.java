package com.example.asm2java202.service;

import com.example.asm2java202.entity.Product;
import com.example.asm2java202.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repo;

    @Override
    public List<Product> findAll() {
        return repo.findAll();
    }

    @Override
    public Product findById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<Product> findByCategory(String cid) {
        return repo.findByCategory_Id(cid);
    }

    @Override
    public Product create(Product product) {
        return repo.save(product);
    }

    @Override
    public Product update(Product product) {
        return repo.save(product);
    }

    @Override
    public void delete(Integer id) {
        repo.deleteById(id);
    }
    @Override
    public List<Product> search(String keyword) {
        return repo.findByNameContainingIgnoreCase(keyword);
    }

    @Override
    public List<Product> sortAsc() {
        return repo.findAllByOrderByPriceAsc();
    }

    @Override
    public List<Product> sortDesc() {
        return repo.findAllByOrderByPriceDesc();
    }

    @Override
    public List<Product> searchAndSortAsc(String keyword) {
        return repo.findByNameContainingIgnoreCaseOrderByPriceAsc(keyword);
    }

    @Override
    public List<Product> searchAndSortDesc(String keyword) {
        return repo.findByNameContainingIgnoreCaseOrderByPriceDesc(keyword);
    }
}
