package com.example.ecommerce.repository;

import com.example.ecommerce.entity.CustomerNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerNoteRepository extends JpaRepository<CustomerNote, Long> {
    CustomerNote findFirstByCode(String code);
}
