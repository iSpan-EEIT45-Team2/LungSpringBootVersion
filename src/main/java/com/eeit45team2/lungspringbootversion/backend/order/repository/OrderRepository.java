package com.eeit45team2.lungspringbootversion.backend.order.repository;

import com.eeit45team2.lungspringbootversion.backend.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    Optional<Order> findByOrderNo(String orderNo);

}
