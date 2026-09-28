package com.example.ecommerce.repository;

import com.example.ecommerce.entity.CustomerTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerTagRepository extends JpaRepository<CustomerTag, Long> {
    CustomerTag findFirstByCode(String code);
}
