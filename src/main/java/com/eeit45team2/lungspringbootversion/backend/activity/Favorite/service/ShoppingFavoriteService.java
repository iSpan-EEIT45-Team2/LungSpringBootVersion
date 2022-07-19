package com.eeit45team2.lungspringbootversion.backend.activity.Favorite.service;

import com.eeit45team2.lungspringbootversion.backend.activity.Favorite.model.FavoriteItem;
import com.eeit45team2.lungspringbootversion.backend.activity.Favorite.model.ShoppingFavorite;
import com.eeit45team2.lungspringbootversion.backend.activity.Favorite.repository.FavoriteItemRepository;
import com.eeit45team2.lungspringbootversion.backend.activity.Favorite.repository.ShoppingFavoriteRepository;
import com.eeit45team2.lungspringbootversion.backend.product.model.ProductBean;
import com.eeit45team2.lungspringbootversion.backend.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Set;

@Service
public class ShoppingFavoriteService {

    @Autowired
    private ShoppingFavoriteRepository shoppingCartRepository;
    @Autowired
    private ProductService productService;
    @Autowired
    private FavoriteItemRepository cartItemRepository;


    public ShoppingFavorite addShoppingCartFirstTime(Integer id, String sessionToken, int quantity) {
        ShoppingFavorite shoppingCart = new ShoppingFavorite();
        FavoriteItem cartItem = new FavoriteItem();
        cartItem.setQuantity(quantity);
        cartItem.setDate(new Date());
        cartItem.setProduct(productService.FindById(id));
        shoppingCart.getItems().add(cartItem);
        shoppingCart.setSessionToken(sessionToken);
        shoppingCart.setDate(new Date());
        return shoppingCartRepository.save(shoppingCart);
    }

    public ShoppingFavorite addToExistingShoppingCart(Integer id, String sessionToken, int quantity) {

        ShoppingFavorite shoppingCart = shoppingCartRepository.findBySessionToken(sessionToken);
        ProductBean productBean = productService.FindById(id);
        boolean productDoesExistInTheCart = false;
        if (shoppingCart != null) {
            Set<FavoriteItem> items = shoppingCart.getItems();
            for (FavoriteItem item : items) {
                if (item.getProduct().equals(productBean)) {
                    productDoesExistInTheCart = true;
                    item.setQuantity(item.getQuantity() + quantity);
                    shoppingCart.setItems(items);
                    return shoppingCartRepository.saveAndFlush(shoppingCart);
                }
            }

        }
        if (shoppingCart != null) {
            FavoriteItem cartItem1 = new FavoriteItem();
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

    public ShoppingFavorite getShoppingCartBySessionToken(String sessionToken) {
        return shoppingCartRepository.findBySessionToken(sessionToken);
    }

    public FavoriteItem updateShoppingCartItem(Long id, int quantity) {
        FavoriteItem cartItem = cartItemRepository.findById(id).get();
        cartItem.setQuantity(quantity);
        return cartItemRepository.saveAndFlush(cartItem);
    }

    public ShoppingFavorite removeCartItemFromShoppingCart(Long id, String sessionToken) {
        ShoppingFavorite shoppingCart = shoppingCartRepository.findBySessionToken(sessionToken);
        Set<FavoriteItem> items = shoppingCart.getItems();
        FavoriteItem cartItem = null;
        for (FavoriteItem item : items) {
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
        ShoppingFavorite sh = shoppingCartRepository.findBySessionToken(sessionToken);
        shoppingCartRepository.delete(sh);
    }
}
