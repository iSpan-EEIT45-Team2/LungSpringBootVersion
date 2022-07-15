package com.eeit45team2.lungspringbootversion.backend.order.service.impl;

import com.eeit45team2.lungspringbootversion.backend.member.service.MemberService;
import com.eeit45team2.lungspringbootversion.backend.order.constant.OrderStatus;
import com.eeit45team2.lungspringbootversion.backend.order.constant.OrderStatusChangeEvent;
import com.eeit45team2.lungspringbootversion.backend.order.model.Order;
import com.eeit45team2.lungspringbootversion.backend.order.repository.OrderRepository;
import com.eeit45team2.lungspringbootversion.backend.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.persist.StateMachinePersister;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class OrderServiceImpl implements OrderService {


    private OrderRepository orderRepository;
    private MemberService memberService;
    private StateMachine<OrderStatus, OrderStatusChangeEvent> orderStateMachine;
    private StateMachinePersister<OrderStatus, OrderStatusChangeEvent, Order> persister;

    public OrderServiceImpl(OrderRepository orderRepository,
                            MemberService memberService,
                            StateMachine<OrderStatus,
                                    OrderStatusChangeEvent> orderStateMachine, StateMachinePersister<OrderStatus, OrderStatusChangeEvent, Order> persister) {
        this.orderRepository = orderRepository;
        this.memberService = memberService;
        this.orderStateMachine = orderStateMachine;
        this.persister = persister;
    }

    @Override

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public void save(Order order) {
        orderRepository.save(order);
    }

    @Override
    public Order FindById(Integer id) {
        return orderRepository.findById(id).get();
        //找到這筆資料回傳,Update方法
    }

    @Override
    public void delete(Integer id) {
        orderRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Optional<Order> findByOrderNo(String orderNo) {
        return orderRepository.findByOrderNo(orderNo);
    }

    @Override
    @Transactional
    public Order pay(Integer orderId) {
        Order order = orderRepository.findById(orderId).orElse(null);
        order.setPayDate(new Date());
        System.out.println("訂單號：" + orderId + " 嘗試支付");
        Mono<Message<OrderStatusChangeEvent>> message = Mono.just(MessageBuilder.withPayload(OrderStatusChangeEvent.PAYED).setHeader("order", order).build());
        if (sendEvent(message, order)) {
            System.out.println("訂單號：" + orderId + " 支付失敗，狀態異常");
        }
        return order;
    }
    private synchronized boolean sendEvent(Mono<Message<OrderStatusChangeEvent>> message, Order order) {
        boolean result = false;
        try {
            //嘗試恢復狀態機狀態
            persister.restore(orderStateMachine, order);
            result = orderStateMachine.sendEvent(message).subscribe().isDisposed();
            //持久化狀態機狀態
            persister.persist(orderStateMachine, order);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return !result;
    }

}
