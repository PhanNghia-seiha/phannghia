package com.example.asm2java202.controller;

import com.example.asm2java202.entity.Product;
import com.example.asm2java202.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/home/index")
    public String home(Model model,
                       @RequestParam(value = "keyword", required = false) String keyword,
                       @RequestParam(value = "sort", required = false) String sort) {

        List<Product> items;

        if (keyword != null && !keyword.isEmpty()) {
            if ("asc".equals(sort)) {
                items = productService.searchAndSortAsc(keyword);
            } else if ("desc".equals(sort)) {
                items = productService.searchAndSortDesc(keyword);
            } else {
                items = productService.search(keyword);
            }
        } else {
            if ("asc".equals(sort)) {
                items = productService.sortAsc();
            } else if ("desc".equals(sort)) {
                items = productService.sortDesc();
            } else {
                items = productService.findAll();
            }
        }

        model.addAttribute("items", items);
        return "home";
    }

    @GetMapping("/product/list-by-category/{id}")
    public String list(Model model, @PathVariable("id") String id){
        model.addAttribute("items", productService.findByCategory(id));
        return "product-list";
    }

    @GetMapping("/product/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id){
        model.addAttribute("item", productService.findById(id));
        return "product-detail";
    }
}
