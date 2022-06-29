package com.eeit45team2.lungspringbootversion.Frontend.Product.service;

import com.eeit45team2.lungspringbootversion.Frontend.Product.model.Product;

import java.util.List;

public interface ProductService {

    public List<Product> findAll();

    public void save(Product product);

    public Product FindById(Long productId);

    public void delete(Long productId);

}
