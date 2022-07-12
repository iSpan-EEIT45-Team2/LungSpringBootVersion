package com.eeit45team2.lungspringbootversion.backend.order.repository;

import com.eeit45team2.lungspringbootversion.backend.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    //Repository 儲存區
}
