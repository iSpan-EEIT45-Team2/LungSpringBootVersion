package com.eeit45team2.lungspringbootversion.backend.activity.service;

import java.util.List;

import com.eeit45team2.lungspringbootversion.backend.activity.model.ActivityBean;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


//@Service
//@Transactional
public interface ActivityService {
	
	//show all
		public List<ActivityBean> findAll();
		
		//save
		public void save(ActivityBean theActivityBean);
		
		//getOrder
		public ActivityBean FindById(long ac_id);
		
		//delete
		public void delete(Long ac_id);
	
}
