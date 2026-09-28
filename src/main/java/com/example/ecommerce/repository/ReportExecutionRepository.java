package com.example.ecommerce.repository;

import com.example.ecommerce.entity.ReportExecution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportExecutionRepository extends JpaRepository<ReportExecution, Long> {
    ReportExecution findFirstByCode(String code);
}
