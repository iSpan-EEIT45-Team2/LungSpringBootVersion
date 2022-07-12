package com.eeit45team2.lungspringbootversion.backend.Cart.controller;

import com.eeit45team2.lungspringbootversion.backend.Cart.model.ShoppingCart;
import com.eeit45team2.lungspringbootversion.backend.Cart.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@Controller
public class CartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

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

        return "redirect:/products";
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
        return "redirect:shoppingCart";
    }

    @GetMapping("/removeItem/{id}")
    public String removeItem(@PathVariable("id") Long id, HttpServletRequest request) {
        String sessionToken = (String) request.getSession(false).getAttribute("sessionToken");
        shoppingCartService.removeCartItemFromShoppingCart(id, sessionToken);
        return "redirect:/shoppingCart";
    }

    @GetMapping("/clearShoppingCart")
    public String clearShoppingCart(HttpServletRequest request) {
        String sessionToken = (String) request.getSession(false).getAttribute("sessionToken");
        request.getSession(false).removeAttribute("sessionToken");
        shoppingCartService.clearShoppingCart(sessionToken);

        return "redirect:/shoppingCart";
    }
}
