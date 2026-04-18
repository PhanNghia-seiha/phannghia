package com.example.asm2java202.config;

import com.example.asm2java202.service.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AuthInterceptor implements HandlerInterceptor {

    private final AuthService authService;

    public AuthInterceptor(AuthService authService) {
        this.authService = authService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {

        String uri = request.getRequestURI();

        // 🔐 CHƯA LOGIN → bắt login
        if(!authService.isLogin()){
            response.sendRedirect("/auth/login");
            return false;
        }

        // 🔐 KHÔNG PHẢI ADMIN → chặn /admin
        if(uri.startsWith("/admin") && !authService.isAdmin()){
            response.sendRedirect("/auth/login");
            return false;
        }

        if(uri.startsWith("/admin") && !authService.isAdmin()){
            response.sendRedirect("/auth/login");
            return false;
        }
        return true;
    }
}
