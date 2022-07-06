package com.eeit45team2.lungspringbootversion.backend.product.repository;

import com.eeit45team2.lungspringbootversion.backend.product.model.ProductBean;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductBean,Long> {
	//Repository 儲存區
}