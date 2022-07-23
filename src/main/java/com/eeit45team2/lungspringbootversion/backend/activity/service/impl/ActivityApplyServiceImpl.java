package com.eeit45team2.lungspringbootversion.backend.activity.service.impl;

import com.eeit45team2.lungspringbootversion.backend.activity.model.ActivityApply;
import com.eeit45team2.lungspringbootversion.backend.activity.repository.ActivityApplyRepository;
import com.eeit45team2.lungspringbootversion.backend.activity.service.ActivityApplyService;
import com.eeit45team2.lungspringbootversion.backend.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ActivityApplyServiceImpl implements ActivityApplyService {


    @Autowired
    private ActivityApplyRepository orderRepository;
    private MemberService memberService;
//    private StateMachine<ApplyStatus, ApplyStatusChangeEvent> orderStateMachine;
//    private StateMachinePersister<ApplyStatus, ApplyStatusChangeEvent, ActivityApply> persister;

//    public ActivityApplyServiceImpl(ActivityApplyRepository orderRepository,
//                                    MemberService memberService,
//                                    StateMachine<OrderStatus,
//                                    OrderStatusChangeEvent> orderStateMachine, StateMachinePersister<OrderStatus, OrderStatusChangeEvent, Order> persister) {
//        this.orderRepository = orderRepository;
//        this.memberService = memberService;
//        this.orderStateMachine = orderStateMachine;
//        this.persister = persister;
//    }

    @Override

    public List<ActivityApply> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public void save(ActivityApply order) {
        orderRepository.save(order);
    }

    @Override
    public ActivityApply FindById(Integer id) {
        return orderRepository.findById(id).get();
        //找到這筆資料回傳,Update方法
    }

    @Override
    public void delete(Integer id) {
        orderRepository.deleteById(id);
    }

    @Override
    @Transactional
    public ActivityApply createOrder(ActivityApply order) {
        return orderRepository.save(order);
    }

//    @Override
//    public Optional<ActivityApply> findByOrderNo(String orderNo) {
//        return orderRepository.findByOrderNo(orderNo);
//    }

//    @Override
//    @Transactional
//    public ActivityApply pay(Integer orderId) {
//        ActivityApply order = orderRepository.findById(orderId).orElse(null);
//        order.setPayDate(new Date());
//        System.out.println("訂單號：" + orderId + " 嘗試支付");
//        Mono<Message<OrderStatusChangeEvent>> message = Mono.just(MessageBuilder.withPayload(OrderStatusChangeEvent.PAYED).setHeader("order", order).build());
//        if (sendEvent(message, order)) {
//            System.out.println("訂單號：" + orderId + " 支付失敗，狀態異常");
//        }
//        return order;
//    }

//    @Override
//    public Optional<Order> findByOrderId(Integer orderId) {
//        return orderRepository.findById(orderId);
//    }
//
//    @Override
//    @Transactional
//    public void deleteOrder(Integer orderId) {
//        orderRepository.deleteById(orderId);
//    }

//    @Override
//    @Transactional
//    public Order deliver(Integer orderId, String trackingNumber) {
//        Order order = orderRepository.findById(orderId).orElse(null);
//        order.setTrackingNumber(trackingNumber);
//        order.setShipDate(new Date());
//        Mono<Message<OrderStatusChangeEvent>> message = Mono.just(MessageBuilder.withPayload(OrderStatusChangeEvent.DELIVERY).setHeader("order", order).build());
//        if (sendEvent(message, order)) {
//            System.out.println("訂單號：" + orderId + " 發貨失敗");
//        }
//        orderRepository.save(order);
//        return order;
//    }

//    @Override
//    @Transactional
//    public Order cancel(Integer orderId) {
//        Order order = orderRepository.findById(orderId).orElse(null);
//        Mono<Message<OrderStatusChangeEvent>> message = Mono.just(MessageBuilder.withPayload(OrderStatusChangeEvent.RECEIVED).setHeader("order", order).build());
//        if (sendEvent(message, order)) {
//            System.out.println("訂單號：" + orderId + " 取消訂單失敗");
//        }
//        return order;
//    }

//    @Override
//    @Transactional
//    public Order receive(Integer orderId) {
//        Order order = orderRepository.findById(orderId).orElse(null);
//        Mono<Message<OrderStatusChangeEvent>> message = Mono.just(MessageBuilder.withPayload(OrderStatusChangeEvent.RECEIVED).setHeader("order", order).build());
//        if (sendEvent(message, order)) {
//            System.out.println("訂單號：" + orderId + " 收貨失敗，狀態異常");
//        }
//        return order;
//    }

//    @Override
//    @Transactional
//    public Order refund(Integer orderId) {
//        Order order = orderRepository.findById(orderId).orElse(null);
//        Mono<Message<OrderStatusChangeEvent>> message = Mono.just(MessageBuilder.withPayload(OrderStatusChangeEvent.REFUND).setHeader("order", order).build());
//        if (sendEvent(message, order)) {
//            System.out.println("訂單號：" + orderId + " 提出退款失敗");
//        }
//        return order;
//    }

//    @Override
//    @Transactional
//    public Order accept(Integer orderId) {
//        Order order = orderRepository.findById(orderId).orElse(null);
//        Mono<Message<OrderStatusChangeEvent>> message = Mono.just(MessageBuilder.withPayload(OrderStatusChangeEvent.ACCEPT).setHeader("order", order).build());
//        if (sendEvent(message, order)) {
//            System.out.println("訂單號：" + orderId + " 同意退款失敗");
//        }
//        return order;
//    }

//    @Override
//    @Transactional
//    public Order reject(Integer orderId) {
//        Order order = orderRepository.findById(orderId).orElse(null);
//        Mono<Message<OrderStatusChangeEvent>> message = Mono.just(MessageBuilder.withPayload(OrderStatusChangeEvent.REJECT).setHeader("order", order).build());
//        if (sendEvent(message, order)) {
//            System.out.println("訂單號：" + orderId + " 拒絕退款失敗");
//        }
//        return order;
//    }

//    @Override
//    public Page<ActivityApply> findAllByOrderStatusAndMember(OrderStatus status, MemberBean memberBean, Pageable pageable) {
//        return orderRepository.findAllByOrderStatusAndMemberBean(status, memberBean, pageable);
//    }
//
//    @Override
//    public Page<ActivityApply> findAllByMember(MemberBean memberBean, Pageable pageable) {
//        if (memberBean == null) {
//            return null;
//        }
//        return orderRepository.findAllByMemberBean(memberBean, pageable);
//    }


//    private synchronized boolean sendEvent(Mono<Message<ApplyStatusChangeEvent>> message, ActivityApply order) {
//        boolean result = false;
//        try {
//            persister.restore(orderStateMachine, order);
//            result = orderStateMachine.sendEvent(message).subscribe().isDisposed();
//            persister.persist(orderStateMachine, order);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return !result;
//    }

}
