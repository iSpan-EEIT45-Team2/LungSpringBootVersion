package com.eeit45team2.lungspringbootversion.backend.Cart.repository;

import com.eeit45team2.lungspringbootversion.backend.Cart.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}
