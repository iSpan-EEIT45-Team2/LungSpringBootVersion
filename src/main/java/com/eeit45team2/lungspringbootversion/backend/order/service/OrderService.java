package com.eeit45team2.lungspringbootversion.backend.order.service;

import java.util.List;

import com.eeit45team2.lungspringbootversion.backend.order.model.OrderBean;

public interface OrderService {
	
		//show all
		public List<OrderBean> findAll();
		
		//save
		public void save(OrderBean theOrderBean);
		
		//FindById
		public OrderBean FindById(Long od_id);
		
		//delete
		public void delete(Long od_id);
	
}
