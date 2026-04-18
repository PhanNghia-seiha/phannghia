package com.example.asm2java202.repository;

import com.example.asm2java202.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, String> {
}
