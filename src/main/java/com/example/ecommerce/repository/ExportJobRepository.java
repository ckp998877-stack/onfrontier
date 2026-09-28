package com.example.ecommerce.repository;

import com.example.ecommerce.entity.ExportJob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExportJobRepository extends JpaRepository<ExportJob, Long> {
    ExportJob findFirstByCode(String code);
}
