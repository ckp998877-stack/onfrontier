package com.example.ecommerce.repository;

import com.example.ecommerce.entity.CategoryAttribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryAttributeRepository extends JpaRepository<CategoryAttribute, Long> {
    CategoryAttribute findFirstByCode(String code);
}
