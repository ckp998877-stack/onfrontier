package com.example.ecommerce.repository;

import com.example.ecommerce.entity.ImportJob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImportJobRepository extends JpaRepository<ImportJob, Long> {
    ImportJob findFirstByCode(String code);
}
