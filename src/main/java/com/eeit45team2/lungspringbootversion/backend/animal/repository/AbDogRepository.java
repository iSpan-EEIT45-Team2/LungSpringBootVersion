package com.eeit45team2.lungspringbootversion.backend.animal.repository;

import com.eeit45team2.lungspringbootversion.backend.animal.model.AbDogBean;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbDogRepository extends JpaRepository<AbDogBean,Long> {
    //Repository 儲存區
}
