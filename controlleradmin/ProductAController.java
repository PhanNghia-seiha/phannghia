package com.example.asm2java202.controlleradmin;

import com.example.asm2java202.entity.Product;
import com.example.asm2java202.service.CategoryService;
import com.example.asm2java202.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/product")
public class ProductAController {

    private final ProductService service;
    private final CategoryService categoryService;

    @GetMapping("/index")
    public String index(Model model){
        model.addAttribute("item", new Product());
        model.addAttribute("items", service.findAll());
        model.addAttribute("categories", categoryService.findAll());
        return "admin/product";
    }

    @PostMapping("/create")
    public String create(Product item){
        service.create(item);
        return "redirect:/admin/product/index";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Integer id){
        model.addAttribute("item", service.findById(id));
        model.addAttribute("items", service.findAll());
        model.addAttribute("categories", categoryService.findAll());
        return "admin/product";
    }

    @PostMapping("/update")
    public String update(Product item){
        service.update(item);
        return "redirect:/admin/product/index";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        service.delete(id);
        return "redirect:/admin/product/index";
    }
}
