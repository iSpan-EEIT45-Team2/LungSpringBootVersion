package com.eeit45team2.lungspringbootversion.backend.Cart.controller;

import com.eeit45team2.lungspringbootversion.backend.Cart.model.ShoppingCart;
import com.eeit45team2.lungspringbootversion.backend.Cart.service.ShoppingCartService;
import com.eeit45team2.lungspringbootversion.backend.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@Controller
@SessionAttributes(value = {"sessionToken", "shoppingCart"})
@RequestMapping("/Front")
public class CartController {


    private ShoppingCartService shoppingCartService;
    private OrderService orderService;

    @Autowired
    public CartController(ShoppingCartService shoppingCartService, OrderService orderService) {
        this.shoppingCartService = shoppingCartService;
        this.orderService = orderService;
    }

    @PostMapping("/addToCart")
    public String addToCart(HttpServletRequest request, Model model, @RequestParam("id") Long id, @RequestParam("quantity") int quantity) {
        String sessionToken = (String) request.getSession(true).getAttribute("sessionToken");
        if (sessionToken == null) {
            sessionToken = UUID.randomUUID().toString();
            request.getSession().setAttribute("sessionToken", sessionToken);
            shoppingCartService.addShoppingCartFirstTime(id, sessionToken, quantity);
        } else {
            shoppingCartService.addToExistingShoppingCart(id, sessionToken, quantity);
        }

        return "redirect:/Front/products";
    }

    @GetMapping("/shoppingCart")
    public String showShoppingCartView(HttpServletRequest request, Model model) {
        String sessionToken = (String) request.getSession(true).getAttribute("sessionToken");
        if (sessionToken == null) {
            model.addAttribute("shoppingCart", new ShoppingCart());

        } else {
            ShoppingCart shoppingCart = shoppingCartService.getShoppingCartBySessionToken(sessionToken);
            model.addAttribute("shoppingCart", shoppingCart);
        }
        return "FrontEnd/Shop/cart";
    }

    @PostMapping("/updateShoppingCart")
    public String updateCartItem(@RequestParam("item_id") Long id, @RequestParam("quantity") int quantity) {

        shoppingCartService.updateShoppingCartItem(id, quantity);
        return "redirect:/Front/shoppingCart";
    }

    @GetMapping("/removeItem/{id}")
    public String removeItem(@PathVariable("id") Long id, HttpServletRequest request) {
        String sessionToken = (String) request.getSession(false).getAttribute("sessionToken");
        shoppingCartService.removeCartItemFromShoppingCart(id, sessionToken);
        return "redirect:/Front/shoppingCart";
    }

    @GetMapping("/clearShoppingCart")
    public String clearShoppingCart(HttpServletRequest request) {
        String sessionToken = (String) request.getSession(false).getAttribute("sessionToken");
        request.getSession(false).removeAttribute("sessionToken");
        shoppingCartService.clearShoppingCart(sessionToken);

        return "redirect:/Front/shoppingCart";
    }

//    @GetMapping("/orders")
//    public String orders(HttpServletRequest request, Model model, @ModelAttribute Order order) {
//        String sessionToken = (String) request.getSession(true).getAttribute("sessionToken");
//        ShoppingCart shoppingCart = shoppingCartService.getShoppingCartBySessionToken(sessionToken);
//        model.addAttribute("shoppingCart", shoppingCart);
//
//
//        return "FrontEnd/Order/Order";
//
//    }
}
