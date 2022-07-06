package com.eeit45team2.lungspringbootversion.FrontEnd.Product.service;

import com.eeit45team2.lungspringbootversion.FrontEnd.Product.model.Product;
import com.eeit45team2.lungspringbootversion.FrontEnd.Product.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    //取得全部Product
    public List<Product> getAllProduct() {
        return productRepo.findAll();
    }

    //新增Product
    public void createProduct(Product product) {
        productRepo.save(product);
    }

    public Product get(int pd_id) {
        return productRepo.findById(pd_id).get();
    }


    //刪除Product

    public void delete(int pd_id) {
        productRepo.deleteById(pd_id);
    }
}
