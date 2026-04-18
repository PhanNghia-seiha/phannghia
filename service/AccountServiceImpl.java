package com.example.asm2java202.service;

import com.example.asm2java202.entity.Account;
import com.example.asm2java202.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository repo;

    @Override
    public List<Account> findAll() {
        return repo.findAll();
    }

    @Override
    public Account findById(String username) {
        return repo.findById(username).orElse(null);
    }

    @Override
    public Account create(Account acc) {
        return repo.save(acc);
    }

    @Override
    public Account update(Account acc) {
        return repo.save(acc);
    }

    @Override
    public void delete(String username) {
        repo.deleteById(username);
    }
}
