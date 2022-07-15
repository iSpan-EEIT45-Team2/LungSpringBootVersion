package com.eeit45team2.lungspringbootversion.backend.Cart.service;

import com.eeit45team2.lungspringbootversion.backend.Cart.model.CartItem;
import com.eeit45team2.lungspringbootversion.backend.Cart.model.ShoppingCart;
import com.eeit45team2.lungspringbootversion.backend.Cart.repository.CartItemRepository;
import com.eeit45team2.lungspringbootversion.backend.Cart.repository.ShoppingCartRepository;
import com.eeit45team2.lungspringbootversion.backend.product.model.ProductBean;
import com.eeit45team2.lungspringbootversion.backend.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Set;

@Service
public class ShoppingCartService {

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;
    @Autowired
    private ProductService productService;
    @Autowired
    private CartItemRepository cartItemRepository;


    public ShoppingCart addShoppingCartFirstTime(Integer id, String sessionToken, int quantity) {
        ShoppingCart shoppingCart = new ShoppingCart();
        CartItem cartItem = new CartItem();
        cartItem.setQuantity(quantity);
        cartItem.setDate(new Date());
        cartItem.setProduct(productService.FindById(id));
        shoppingCart.getItems().add(cartItem);
        shoppingCart.setSessionToken(sessionToken);
        shoppingCart.setDate(new Date());
        return shoppingCartRepository.save(shoppingCart);
    }

    public ShoppingCart addToExistingShoppingCart(Integer id, String sessionToken, int quantity) {

        ShoppingCart shoppingCart = shoppingCartRepository.findBySessionToken(sessionToken);
        ProductBean productBean = productService.FindById(id);
        boolean productDoesExistInTheCart = false;
        if (shoppingCart != null) {
            Set<CartItem> items = shoppingCart.getItems();
            for (CartItem item : items) {
                if (item.getProduct().equals(productBean)) {
                    productDoesExistInTheCart = true;
                    item.setQuantity(item.getQuantity() + quantity);
                    shoppingCart.setItems(items);
                    return shoppingCartRepository.saveAndFlush(shoppingCart);
                }
            }

        }
        if (shoppingCart != null) {
            CartItem cartItem1 = new CartItem();
            cartItem1.setDate(new Date());
            cartItem1.setQuantity(quantity);
            cartItem1.setProduct(productBean);
            shoppingCart.getItems().add(cartItem1);
            return shoppingCartRepository.saveAndFlush(shoppingCart);
        }
        return this.addShoppingCartFirstTime(id, sessionToken, quantity);

//        for (CartItem cartItem : shoppingCart.getItems()) {
//            if (productBean.getPd_id().equals(cartItem.getProductBean().getPd_id())) {
//                cartItem.setQuantity(cartItem.getQuantity() + quantity);
//                return shoppingCartRepository.save(shoppingCart);
//            }
//        }
//        CartItem cartItem = new CartItem();
//        cartItem.setDate(new Date());
//        cartItem.setQuantity(quantity);
//        cartItem.setProductBean(productBean);
//        shoppingCart.getItems().add(cartItem);
//        return shoppingCartRepository.save(shoppingCart);
    }

    public ShoppingCart getShoppingCartBySessionToken(String sessionToken) {
        return shoppingCartRepository.findBySessionToken(sessionToken);
    }

    public CartItem updateShoppingCartItem(Long id, int quantity) {
        CartItem cartItem = cartItemRepository.findById(id).get();
        cartItem.setQuantity(quantity);
        return cartItemRepository.saveAndFlush(cartItem);
    }

    public ShoppingCart removeCartItemFromShoppingCart(Long id, String sessionToken) {
        ShoppingCart shoppingCart = shoppingCartRepository.findBySessionToken(sessionToken);
        Set<CartItem> items = shoppingCart.getItems();
        CartItem cartItem = null;
        for (CartItem item : items) {
            if (item.getId().equals(id)) {
                cartItem = item;
            }
        }
        items.remove(cartItem);
        assert cartItem != null;
        cartItemRepository.delete(cartItem);
        shoppingCart.setItems(items);
        return shoppingCartRepository.save(shoppingCart);
    }

    public void clearShoppingCart(String sessionToken) {
        ShoppingCart sh = shoppingCartRepository.findBySessionToken(sessionToken);
        shoppingCartRepository.delete(sh);
    }
}
