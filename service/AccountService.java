package com.example.asm2java202.service;

import com.example.asm2java202.entity.Account;

import java.util.List;

public interface AccountService {
    List<Account> findAll();
    Account findById(String username);
    Account create(Account acc);
    Account update(Account acc);
    void delete(String username);
}
