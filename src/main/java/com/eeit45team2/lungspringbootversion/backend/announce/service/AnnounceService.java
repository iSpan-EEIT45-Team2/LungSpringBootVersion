package com.eeit45team2.lungspringbootversion.backend.Announce.service;

import com.eeit45team2.lungspringbootversion.backend.Announce.model.AnnounceBean;

import java.util.List;

public interface AnnouncerService {
	
		//show all
		public List<AnnounceBean> findAll();
		
		//save
		public void save(AnnounceBean theAnnounceBean);
		
		//FindById
		public AnnounceBean FindById(Long od_id);
		
		//delete
		public void delete(Long od_id);
	
}
