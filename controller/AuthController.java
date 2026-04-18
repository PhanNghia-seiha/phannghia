package com.example.asm2java202.controller;

import com.example.asm2java202.entity.Account;
import com.example.asm2java202.service.AccountService;
import com.example.asm2java202.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AccountService accountService;
    private final AuthService authService;


    @GetMapping("/login")
    public String loginForm(){
        return "login";
    }


    @PostMapping("/login")
    public String login(Model model,
                        @RequestParam("username") String username,
                        @RequestParam("password") String password){

        Account user = accountService.findById(username);

        if(user == null || !user.getPassword().equals(password)){
            model.addAttribute("error", "Sai tài khoản hoặc mật khẩu!");
            return "login";
        }

        authService.login(user);
        return "redirect:/home/index";
    }

    @GetMapping("/logout")
    public String logout(){
        authService.logout();
        return "redirect:/auth/login";
    }
}
