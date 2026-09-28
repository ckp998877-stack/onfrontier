package com.example.ecommerce.repository;

import com.example.ecommerce.entity.StoreLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreLocationRepository extends JpaRepository<StoreLocation, Long> {
    StoreLocation findFirstByCode(String code);
}
