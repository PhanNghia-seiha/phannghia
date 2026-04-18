package com.example.asm2java202.controlleradmin;

import com.example.asm2java202.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/order")
public class OrderAController {

    private final OrderService service;

    @GetMapping("/index")
    public String index(Model model){
        model.addAttribute("items", service.findAll());
        return "admin/order";
    }
}
