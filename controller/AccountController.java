package com.example.asm2java202.controller;

import com.example.asm2java202.entity.Account;
import com.example.asm2java202.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/sign-up")
    public String form(Model model){
        model.addAttribute("user", new Account());
        return "sign-up";
    }

    @PostMapping("/sign-up")
    public String signup(@ModelAttribute("user") Account user){
        user.setActivated(true);
        user.setAdmin(false);
        accountService.create(user);
        return "redirect:/auth/login";
    }

    @GetMapping("/edit-profile")
    public String edit(){
        return "edit-profile";
    }

    @GetMapping("/forgot-password")
    public String forgot(){
        return "forgot-password";
    }

    @GetMapping("/change-password")
    public String change(){
        return "change-password";
    }
}
