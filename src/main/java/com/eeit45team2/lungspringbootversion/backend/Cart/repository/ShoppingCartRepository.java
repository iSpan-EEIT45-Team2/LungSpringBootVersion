package com.eeit45team2.lungspringbootversion.backend.Cart.repository;

import com.eeit45team2.lungspringbootversion.backend.Cart.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
    ShoppingCart findBySessionToken(String sessionToken);
}
