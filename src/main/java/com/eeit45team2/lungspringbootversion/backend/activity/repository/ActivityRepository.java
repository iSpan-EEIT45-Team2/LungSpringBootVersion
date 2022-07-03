package com.eeit45team2.lungspringbootversion.backend.activity.repository;

import java.util.List;

import com.eeit45team2.lungspringbootversion.backend.order.model.OrderBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eeit45team2.lungspringbootversion.backend.activity.model.ActivityBean;

@Repository
public interface ActivityRepository extends JpaRepository<ActivityBean, Long> {
	//Repository 儲存區
}
