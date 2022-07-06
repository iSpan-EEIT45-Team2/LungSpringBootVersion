package com.eeit45team2.lungspringbootversion.backend.product.service;

import java.util.List;

import com.eeit45team2.lungspringbootversion.backend.product.model.ProductBean;


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

