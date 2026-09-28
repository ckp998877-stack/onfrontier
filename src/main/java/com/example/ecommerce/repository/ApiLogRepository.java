package com.example.ecommerce.repository;

import com.example.ecommerce.entity.ApiLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApiLogRepository extends JpaRepository<ApiLog, Long> {
    ApiLog findFirstByCode(String code);
}
