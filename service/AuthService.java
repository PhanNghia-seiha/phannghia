package com.example.asm2java202.service;

import com.example.asm2java202.entity.Account;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final HttpSession session;

    public AuthService(HttpSession session) {
        this.session = session;
    }

    public void login(Account user){
        session.setAttribute("USER", user);
    }

    public void logout(){
        session.removeAttribute("USER");
    }

    public Account getUser(){
        return (Account) session.getAttribute("USER");
    }

    public boolean isLogin(){
        return getUser() != null;
    }

    public boolean isAdmin(){
        return isLogin() && getUser().getAdmin();
    }
    public Account getCurrentUser(){
        return (Account) session.getAttribute("user");
    }
}
