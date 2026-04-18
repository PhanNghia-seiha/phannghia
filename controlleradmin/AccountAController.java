package com.example.asm2java202.controlleradmin;

import com.example.asm2java202.entity.Account;
import com.example.asm2java202.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/account")
public class AccountAController {

    private final AccountService service;

    @GetMapping("/index")
    public String index(Model model){
        model.addAttribute("item", new Account());
        model.addAttribute("items", service.findAll());
        return "admin/account";
    }

    @PostMapping("/create")
    public String create(Account item){
        service.create(item);
        return "redirect:/admin/account/index";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable String id){
        model.addAttribute("item", service.findById(id));
        model.addAttribute("items", service.findAll());
        return "admin/account";
    }

    @PostMapping("/update")
    public String update(Account item){
        service.update(item);
        return "redirect:/admin/account/index";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id){
        service.delete(id);
        return "redirect:/admin/account/index";
    }
}
