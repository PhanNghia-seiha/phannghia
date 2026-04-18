package com.example.asm2java202.controlleradmin;

import com.example.asm2java202.entity.Category;
import com.example.asm2java202.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/category")
public class CategoryAController {

    private final CategoryService service;

    @GetMapping("/index")
    public String index(Model model){
        model.addAttribute("item", new Category());
        model.addAttribute("items", service.findAll());
        return "admin/category";
    }

    @PostMapping("/create")
    public String create(Category item){
        service.create(item);
        return "redirect:/admin/category/index";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable String id){
        model.addAttribute("item", service.findById(id));
        model.addAttribute("items", service.findAll());
        return "admin/category";
    }

    @PostMapping("/update")
    public String update(Category item){
        service.update(item);
        return "redirect:/admin/category/index";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id){
        service.delete(id);
        return "redirect:/admin/category/index";
    }
}
