package com.example.ecommerce.repository;

import com.example.ecommerce.entity.FaqCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FaqCategoryRepository extends JpaRepository<FaqCategory, Long> {
    FaqCategory findFirstByCode(String code);
}
