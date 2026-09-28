package com.example.ecommerce.repository;

import com.example.ecommerce.entity.SupplierContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierContactRepository extends JpaRepository<SupplierContact, Long> {
    SupplierContact findFirstByCode(String code);
}
