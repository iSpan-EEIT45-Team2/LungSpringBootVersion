package com.eeit45team2.lungspringbootversion.backend.order.service;

import com.eeit45team2.lungspringbootversion.backend.order.model.OrderBean;

import java.util.List;

public interface OrderService {

    //show all
    public List<OrderBean> findAll();

    //save
    public void save(OrderBean theOrderBean);

    //FindById
    public OrderBean FindById(Long od_id);

    //delete
    public void delete(Long od_id);

    public void testDelete(String od_id);

}
