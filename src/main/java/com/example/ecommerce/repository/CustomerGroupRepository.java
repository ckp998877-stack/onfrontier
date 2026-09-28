package com.example.ecommerce.repository;

import com.example.ecommerce.entity.CustomerGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerGroupRepository extends JpaRepository<CustomerGroup, Long> {
    CustomerGroup findFirstByCode(String code);
}
