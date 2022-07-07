package com.eeit45team2.lungspringbootversion.backend.product.service;

import com.eeit45team2.lungspringbootversion.backend.product.model.ProductBean;

import java.util.List;


public interface ProductService {

    //show all
    public List<ProductBean> findAll();

    //save
    public void save(ProductBean theProductBean);

    //getOrder
    public ProductBean FindById(Long pd_id);

    //delete
    public void delete(Long pd_id);


}

