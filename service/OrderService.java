package com.example.asm2java202.service;

import com.example.asm2java202.entity.Account;
import com.example.asm2java202.entity.Order;
import com.example.asm2java202.model.CartItem;

import java.util.List;

public interface OrderService {
    List<Order> findAll();
    Order findById(Long id);
    List<Order> findByUser(String username);
    Order create(Order order);
    void checkout(Account user, List<CartItem> cartItems);
}
