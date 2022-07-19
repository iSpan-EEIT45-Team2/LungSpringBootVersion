package com.eeit45team2.lungspringbootversion.backend.activity.Favorite.repository;

import com.eeit45team2.lungspringbootversion.backend.activity.Favorite.model.ShoppingFavorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingFavoriteRepository extends JpaRepository<ShoppingFavorite, Long> {
    ShoppingFavorite findBySessionToken(String sessionToken);
}
