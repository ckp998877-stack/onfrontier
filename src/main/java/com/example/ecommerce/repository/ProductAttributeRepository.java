package com.example.ecommerce.repository;

import com.example.ecommerce.entity.ProductAttribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductAttributeRepository extends JpaRepository<ProductAttribute, Long> {
    ProductAttribute findFirstByCode(String code);
}
