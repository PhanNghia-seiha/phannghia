package com.example.asm2java202.dto;

import lombok.*;

import java.util.Date;

public class VipCustomer {
    private String username;
    private Double totalMoney;
    private Date firstDate;
    private Date lastDate;

    // 🔥 QUAN TRỌNG NHẤT
    public VipCustomer(String username, Double totalMoney, Date firstDate, Date lastDate) {
        this.username = username;
        this.totalMoney = totalMoney;
        this.firstDate = firstDate;
        this.lastDate = lastDate;
    }

    // getter (có thể dùng Lombok nếu muốn)
}
