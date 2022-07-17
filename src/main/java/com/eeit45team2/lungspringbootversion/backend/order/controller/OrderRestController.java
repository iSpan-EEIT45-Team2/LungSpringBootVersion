package com.eeit45team2.lungspringbootversion.backend.order.controller;

import com.eeit45team2.lungspringbootversion.backend.member.model.MemberBean;
import com.eeit45team2.lungspringbootversion.backend.member.service.MemberService;
import com.eeit45team2.lungspringbootversion.backend.order.constant.OrderStatus;
import com.eeit45team2.lungspringbootversion.backend.order.constant.OrderStatusConverter;
import com.eeit45team2.lungspringbootversion.backend.order.model.Order;
import com.eeit45team2.lungspringbootversion.backend.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
public class OrderRestController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private MemberService memberService;


    @GetMapping("/Orders")
    public ResponseEntity<Order> getOrders(
            @RequestParam(required = false) String orderStatus,
            @RequestParam(required = false) Integer page,
            Principal principal) {
        if (principal == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        OrderStatusConverter orderStatusConverter = new OrderStatusConverter();
        OrderStatus status = null;
        MemberBean memberBean = memberService.findByMiAccount(principal.getName());

        Order orders = null;

        orders = orderService.findAllByMember(memberBean);

        return ResponseEntity.status(HttpStatus.OK).body(orders);
    }

    //查詢單筆
    @GetMapping("/Orders/{orderId}")
    public ResponseEntity<Order> getOrder(@PathVariable Integer orderId) {
        Order order = orderService.findByOrderId(orderId).orElse(null);

        if (order != null) {
            return ResponseEntity.status(HttpStatus.OK).body(order);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/Orders/{orderId}")
    public ResponseEntity<?> deleteOrder(@PathVariable Integer orderId) {
        orderService.deleteOrder(orderId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
