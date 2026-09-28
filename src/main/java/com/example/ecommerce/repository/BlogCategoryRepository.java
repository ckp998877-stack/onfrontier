package com.example.ecommerce.repository;

import com.example.ecommerce.entity.BlogCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogCategoryRepository extends JpaRepository<BlogCategory, Long> {
    BlogCategory findFirstByCode(String code);
}
