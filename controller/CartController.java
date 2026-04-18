package com.example.asm2java202.controller;

import com.example.asm2java202.service.CartService;
import com.example.asm2java202.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;
    private final ProductService productService;

    @GetMapping("/view")
    public String view(Model model){
        model.addAttribute("items", cartService.getItems());
        model.addAttribute("total", cartService.getTotal());
        return "cart";
    }

    @GetMapping("/add/{id}")
    public String add(@PathVariable Integer id){
        cartService.add(productService.findById(id));
        return "redirect:/cart/view";
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable Integer id){
        cartService.remove(id);
        return "redirect:/cart/view";
    }

    @PostMapping("/update")
    public String update(@RequestParam Integer id,
                         @RequestParam int qty){
        cartService.update(id, qty);
        return "redirect:/cart/view";
    }

    @GetMapping("/clear")
    public String clear(){
        cartService.clear();
        return "redirect:/cart/view";
    }
}
