package com.eeit45team2.lungspringbootversion.Frontend.Product.service.impl;

import com.eeit45team2.lungspringbootversion.Frontend.Product.model.Product;
import com.eeit45team2.lungspringbootversion.Frontend.Product.repo.ProductRepo;
import com.eeit45team2.lungspringbootversion.Frontend.Product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepo productRepo;

    @Override
    public List<Product> findAll() {
        return productRepo.findAll();
    }

    @Override
    public void save(Product product) {
        productRepo.save(product);
    }

    @Override
    public Product FindById(Long productId) {
        return productRepo.findById(productId).get();
    }

    @Override
    public void delete(Long productId) {
        Long id = Long.valueOf(productId);
        productRepo.deleteById(id);
    }
}
