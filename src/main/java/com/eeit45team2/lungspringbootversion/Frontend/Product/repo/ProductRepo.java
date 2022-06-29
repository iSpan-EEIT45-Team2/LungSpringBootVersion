package com.eeit45team2.lungspringbootversion.Frontend.Product.repo;

import com.eeit45team2.lungspringbootversion.Frontend.Product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Long> {
}
