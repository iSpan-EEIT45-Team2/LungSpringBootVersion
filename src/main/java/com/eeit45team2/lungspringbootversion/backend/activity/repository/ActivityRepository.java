package com.eeit45team2.lungspringbootversion.backend.activity.repository;

import com.eeit45team2.lungspringbootversion.backend.activity.model.ActivityBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository extends JpaRepository<ActivityBean, Long> {
    //Repository 儲存區
}
