package com.example.ecommerce.repository;

import com.example.ecommerce.entity.RecentlyViewed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecentlyViewedRepository extends JpaRepository<RecentlyViewed, Long> {
    RecentlyViewed findFirstByCode(String code);
}
