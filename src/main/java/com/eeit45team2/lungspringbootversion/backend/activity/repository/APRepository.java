package com.eeit45team2.lungspringbootversion.backend.activity.repository;

import com.eeit45team2.lungspringbootversion.backend.activity.model.ActivityBean;
import com.eeit45team2.lungspringbootversion.backend.activity.model.MemberActivityBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface APRepository extends JpaRepository<MemberActivityBean, Long> {
	//Repository 儲存區
}
