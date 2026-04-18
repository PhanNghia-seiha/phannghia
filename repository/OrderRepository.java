package com.example.asm2java202.repository;

import com.example.asm2java202.dto.VipCustomer;
import com.example.asm2java202.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByAccount_Username(String username);
    @Query("""
SELECT new com.example.asm2java202.dto.VipCustomer(
    o.account.username,
    SUM(od.price * od.quantity),
    MIN(o.createDate),
    MAX(o.createDate)
)
FROM Order o
JOIN o.orderDetails od
GROUP BY o.account.username
ORDER BY SUM(od.price * od.quantity) DESC
""")
    List<VipCustomer> getVipCustomers();
}
