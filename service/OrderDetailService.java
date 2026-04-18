package com.example.asm2java202.service;

import com.example.asm2java202.entity.OrderDetail;
import com.example.asm2java202.repository.OrderDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderDetailService {

    private final OrderDetailRepository repo;

    public OrderDetail create(OrderDetail od){
        return repo.save(od);
    }
    public List<OrderDetail> findByUser(String username){
        return repo.findByOrder_Account_Username(username);
    }
    public List<OrderDetail> findByOrder(Long orderId){
        return repo.findByOrder_Id(orderId);
    }
}
