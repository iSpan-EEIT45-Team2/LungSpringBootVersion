package com.eeit45team2.lungspringbootversion.FrontEnd.Cart;

import com.eeit45team2.lungspringbootversion.backend.product.model.ProductBean;
import com.eeit45team2.lungspringbootversion.backend.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class CartService implements CartRepo {

    @Autowired
    private ProductRepository productRepository;

    private Map<ProductBean, Integer> products = new HashMap<>();

    @Override

    public void addProduct(ProductBean product) {
        if (products.containsKey(product)) {
            products.replace(product, products.get(product) + 1);
        } else {
            products.put(product, 1);
        }
    }

    @Override
    public void removeProduct(ProductBean product) {
        if (products.containsKey(product)) {
            products.remove(product);
        }
    }

    @Override
    public Map<ProductBean, Integer> getProductsInCart() {
        return Collections.unmodifiableMap(products);
    }

    @Override
    public void checkOut() {
        ProductBean product;
        for (Map.Entry<ProductBean, Integer> entry : products.entrySet()) {

            product = productRepository.getOne(entry.getKey().getPd_id());

            if (product.getPd_quantity() < entry.getValue()) {

            } else
                entry.getKey().setPd_quantity(product.getPd_quantity() - entry.getValue());

        }
        productRepository.saveAll(products.keySet());
        productRepository.flush();
        products.clear();
    }

    @Override
    public Double getTotal() {
        return null;
    }
}
