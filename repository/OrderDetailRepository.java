package com.example.asm2java202.repository;

import com.example.asm2java202.dto.Report;
import com.example.asm2java202.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
    @Query("""
    SELECT p.category.name as category,
           SUM(od.price * od.quantity) as revenue,
           SUM(od.quantity) as quantity,
           MAX(od.price) as maxPrice,
           MIN(od.price) as minPrice,
           AVG(od.price) as avgPrice
    FROM OrderDetail od
    JOIN od.product p
    GROUP BY p.category.name
""")
    List<Report> getRevenueByCategory();
    List<OrderDetail> findByOrder_Account_Username(String username);
    List<OrderDetail> findByOrder_Id(Long orderId);


}
