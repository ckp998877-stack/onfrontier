package com.example.ecommerce.repository;

import com.example.ecommerce.entity.SavedAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SavedAddressRepository extends JpaRepository<SavedAddress, Long> {
    SavedAddress findFirstByCode(String code);
}
