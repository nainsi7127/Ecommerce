package com.jpa.ecomm_ops.repository;

import com.jpa.ecomm_ops.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    Order findByOrderTrackingNumber(String trackingNumber);
}