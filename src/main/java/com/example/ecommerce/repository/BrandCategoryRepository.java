package com.example.ecommerce.repository;

import com.example.ecommerce.entity.BrandCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandCategoryRepository extends JpaRepository<BrandCategory, Long> {
    BrandCategory findFirstByCode(String code);
}
