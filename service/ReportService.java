package com.example.asm2java202.service;

import com.example.asm2java202.dto.Report;
import com.example.asm2java202.dto.VipCustomer;

import java.util.List;

public interface ReportService {
    List<Report> getRevenue();
    List<VipCustomer> getVip();
}