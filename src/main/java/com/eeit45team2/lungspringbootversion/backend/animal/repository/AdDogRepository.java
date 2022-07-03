package com.eeit45team2.lungspringbootversion.backend.animal.repository;

import com.eeit45team2.lungspringbootversion.backend.animal.model.AbDogBean;
import com.eeit45team2.lungspringbootversion.backend.animal.model.AdDogBean;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdDogRepository extends JpaRepository<AdDogBean,Long> {
    //Repository 儲存區
}
