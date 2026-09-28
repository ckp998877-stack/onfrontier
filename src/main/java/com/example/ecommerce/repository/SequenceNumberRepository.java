package com.example.ecommerce.repository;

import com.example.ecommerce.entity.SequenceNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SequenceNumberRepository extends JpaRepository<SequenceNumber, Long> {
    SequenceNumber findFirstByCode(String code);
}
