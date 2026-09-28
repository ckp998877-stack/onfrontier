package com.example.ecommerce.repository;

import com.example.ecommerce.entity.ReportDefinition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportDefinitionRepository extends JpaRepository<ReportDefinition, Long> {
    ReportDefinition findFirstByCode(String code);
}
