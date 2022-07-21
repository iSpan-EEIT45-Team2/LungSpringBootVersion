package com.eeit45team2.lungspringbootversion.backend.activity.Favorite.repository;

import com.eeit45team2.lungspringbootversion.backend.activity.Favorite.model.FavoriteItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoriteItemRepository extends JpaRepository<FavoriteItem, Long> {
}
