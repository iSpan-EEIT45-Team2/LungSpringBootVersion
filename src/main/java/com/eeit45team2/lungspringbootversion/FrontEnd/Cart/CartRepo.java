package com.eeit45team2.lungspringbootversion.FrontEnd.Cart;

import com.eeit45team2.lungspringbootversion.backend.product.model.ProductBean;

import java.util.Map;

public interface CartRepo {
    void addProduct(ProductBean product);

    void removeProduct(ProductBean product);

    Map<ProductBean, Integer> getProductsInCart();

    void checkOut();

    Double getTotal();
}
