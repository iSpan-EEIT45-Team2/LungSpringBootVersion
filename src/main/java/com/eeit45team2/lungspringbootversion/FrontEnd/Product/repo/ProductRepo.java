package com.eeit45team2.lungspringbootversion.FrontEnd.Product.repo;

import com.eeit45team2.lungspringbootversion.FrontEnd.Product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Integer> {
}
