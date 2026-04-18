package com.example.asm2java202.service;

import com.example.asm2java202.entity.Account;
import com.example.asm2java202.entity.Order;
import com.example.asm2java202.entity.OrderDetail;
import com.example.asm2java202.model.CartItem;
import com.example.asm2java202.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository repo;
    private final OrderDetailService orderDetailService; // 👉 thêm dòng này

    @Override
    public List<Order> findAll() {
        return repo.findAll();
    }

    @Override
    public Order findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<Order> findByUser(String username) {
        return repo.findByAccount_Username(username);
    }

    @Override
    public Order create(Order order) {
        return repo.save(order);
    }

    // 🔥 THÊM HÀM NÀY (QUAN TRỌNG NHẤT)
    @Override
    public void checkout(Account user, List<CartItem> cartItems) {
        Order order = new Order();
        order.setAccount(user);
        order.setCreateDate(new Date());

        Order savedOrder = repo.save(order);

        // 👉 Lưu OrderDetail
        for (CartItem item : cartItems) {
            OrderDetail od = new OrderDetail();
            od.setOrder(savedOrder);
            od.setProduct(item.getProduct());
            od.setPrice(item.getProduct().getPrice());
            od.setQuantity(item.getQuantity());

            orderDetailService.create(od);
        }
    }
}
