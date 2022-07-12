package com.eeit45team2.lungspringbootversion.backend.order.service;

import com.eeit45team2.lungspringbootversion.backend.order.model.Order;

import java.util.List;

public interface OrderService {

    //show all
    public List<Order> findAll();

    //save
    public void save(Order order);

    //FindById
    public Order FindById(Integer id);

    //delete
    public void delete(Integer id);


}
