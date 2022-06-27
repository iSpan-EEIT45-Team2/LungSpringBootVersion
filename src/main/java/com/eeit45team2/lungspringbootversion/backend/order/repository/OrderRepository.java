package com.eeit45team2.lungspringbootversion.backend.order.repository;

import com.eeit45team2.lungspringbootversion.backend.order.model.OrderBean;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderBean,Long> {
    //Repository 儲存區
}
