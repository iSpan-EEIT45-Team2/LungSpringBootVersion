package com.eeit45team2.lungspringbootversion.backend.order.service;

import com.eeit45team2.lungspringbootversion.backend.order.model.Order;
import org.aspectj.weaver.ast.Or;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    //show all
    public List<Order> findAll();

    //save
    public void save(Order order);

    //FindById
    public Order FindById(Integer id);

    //delete
    public void delete(Integer id);

    Order createOrder(Order order);


    Optional<Order> findByOrderNo(String orderNo);

    Order pay(Integer orderId);
}
