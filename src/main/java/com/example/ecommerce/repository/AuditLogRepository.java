package com.example.ecommerce.repository;

import com.example.ecommerce.entity.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {
    AuditLog findFirstByCode(String code);
}
