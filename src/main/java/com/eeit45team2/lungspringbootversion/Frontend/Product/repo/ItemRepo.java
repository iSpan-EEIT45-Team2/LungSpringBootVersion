package com.eeit45team2.lungspringbootversion.Frontend.Product.repo;

import com.eeit45team2.lungspringbootversion.Frontend.Product.model.ItemBean;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepo extends JpaRepository<ItemBean, Long> {
}
