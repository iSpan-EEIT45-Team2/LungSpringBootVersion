package com.eeit45team2.lungspringbootversion.backend.order.service.impl;

import com.eeit45team2.lungspringbootversion.backend.order.model.OrderBean;
import com.eeit45team2.lungspringbootversion.backend.order.repository.OrderRepository;
import com.eeit45team2.lungspringbootversion.backend.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override

    public List<OrderBean> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public void save(OrderBean theOrderBean) {
        orderRepository.save(theOrderBean);
    }

    @Override
    public OrderBean FindById(Long od_id) {
        return orderRepository.findById(od_id).get();
        //找到這筆資料回傳,Update方法
    }

    @Override
    public void delete(Long od_id) {
        orderRepository.deleteById(od_id);
    }

}
