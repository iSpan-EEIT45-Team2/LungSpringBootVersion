package com.eeit45team2.lungspringbootversion.backend.product.service.impl;

import com.eeit45team2.lungspringbootversion.backend.product.model.ProductBean;
import com.eeit45team2.lungspringbootversion.backend.product.repository.ProductRepository;
import com.eeit45team2.lungspringbootversion.backend.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override

    public List<ProductBean> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void save(ProductBean theProductBean) {
        productRepository.save(theProductBean);
    }

    @Override
    public ProductBean FindById(Long pd_id) {
        return productRepository.findById(pd_id).get();
        //找到這筆資料回傳,Update方法
    }

    @Override
    public void delete(Long pd_id) {
        productRepository.deleteById(pd_id);
    }

   
}
