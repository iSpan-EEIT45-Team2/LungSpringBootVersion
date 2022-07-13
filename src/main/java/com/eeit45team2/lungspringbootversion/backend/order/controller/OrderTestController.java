package com.eeit45team2.lungspringbootversion.backend.order.controller;

import com.eeit45team2.lungspringbootversion.backend.Cart.model.ShoppingCart;
import com.eeit45team2.lungspringbootversion.backend.Cart.service.ShoppingCartService;
import com.eeit45team2.lungspringbootversion.backend.order.model.Order;
import com.eeit45team2.lungspringbootversion.backend.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/Front")
public class OrderTestController {


    private ShoppingCartService shoppingCartService;
    private OrderService orderService;

    @Autowired
    public OrderTestController(ShoppingCartService shoppingCartService, OrderService orderService) {
        this.shoppingCartService = shoppingCartService;
        this.orderService = orderService;
    }

    @GetMapping("/orders")
    public String orders(HttpServletRequest request, Model model, @ModelAttribute Order order) {
        String sessionToken = (String) request.getSession(true).getAttribute("sessionToken");
        ShoppingCart shoppingCart = shoppingCartService.getShoppingCartBySessionToken(sessionToken);
        model.addAttribute("shoppingCart", shoppingCart);


        return "FrontEnd/Order/Order";
    }
}