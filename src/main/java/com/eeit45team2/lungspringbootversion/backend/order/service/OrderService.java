package com.eeit45team2.lungspringbootversion.backend.order.service;

import com.eeit45team2.lungspringbootversion.backend.member.model.MemberBean;
import com.eeit45team2.lungspringbootversion.backend.order.model.Order;

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

    Optional<Order> findByOrderId(Integer orderId);

    void deleteOrder(Integer orderId);

    //發貨
    Order deliver(Integer orderId, String trackingNumber);

    //取消
    Order cancel(Integer orderId);

    //收貨
    Order receive(Integer orderId);

    //提出退款
    Order refund(Integer orderId);

    //退款同意
    Order accept(Integer orderId);

    //退款拒絕
    Order reject(Integer orderId);

    Order findAllByMember(MemberBean memberBean);
}
