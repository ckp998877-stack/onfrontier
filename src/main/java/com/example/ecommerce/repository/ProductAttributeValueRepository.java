package com.example.ecommerce.repository;

import com.example.ecommerce.entity.ProductAttributeValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductAttributeValueRepository extends JpaRepository<ProductAttributeValue, Long> {
    ProductAttributeValue findFirstByCode(String code);
}
