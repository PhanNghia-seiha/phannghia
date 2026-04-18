package com.example.asm2java202.controller;

import com.example.asm2java202.entity.Account;
import com.example.asm2java202.entity.Order;
import com.example.asm2java202.service.AuthService;
import com.example.asm2java202.service.CartService;
import com.example.asm2java202.service.OrderDetailService;
import com.example.asm2java202.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;
    private final OrderDetailService orderDetailService;
    private final AuthService authService;
    private final CartService cartService;

    // 🔥 CHECKOUT
    @GetMapping("/checkout")
    public String checkout(){
        Account user = authService.getCurrentUser();

        orderService.checkout(user, cartService.getItems().stream().toList());
        cartService.clear();

        return "redirect:/order/list";
    }

    // 📋 DANH SÁCH ĐƠN
    @GetMapping("/list")
    public String list(Model model){
        String username = authService.getCurrentUser().getUsername();

        model.addAttribute("items", orderService.findByUser(username));
        return "order-list";
    }

    // 🔍 CHI TIẾT ĐƠN
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Long id, Model model){
        model.addAttribute("items", orderDetailService.findByOrder(id));
        return "order-detail";
    }

    // 🛒 SẢN PHẨM ĐÃ MUA
    @GetMapping("/my-product")
    public String myProduct(Model model){
        String username = authService.getCurrentUser().getUsername();

        model.addAttribute("items", orderDetailService.findByUser(username));
        return "my-product";
    }
}
