package com.example.asm2java202.service;

import com.example.asm2java202.dto.Report;
import com.example.asm2java202.dto.VipCustomer;
import com.example.asm2java202.repository.OrderDetailRepository;
import com.example.asm2java202.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {

    private final OrderDetailRepository orderDetailRepo;
    private final OrderRepository orderRepo;

    @Override
    public List<Report> getRevenue() {
        return orderDetailRepo.getRevenueByCategory();
    }

    @Override
    public List<VipCustomer> getVip() {
        return orderRepo.getVipCustomers();
    }
}
