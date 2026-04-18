package com.example.asm2java202.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Accounts")
public class Account {
    @Id
    private String username;

    private String password;
    private String fullname;
    private String email;
    private String photo;
    private Boolean activated;
    private Boolean admin;
}
