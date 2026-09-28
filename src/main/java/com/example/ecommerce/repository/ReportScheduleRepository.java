package com.example.ecommerce.repository;

import com.example.ecommerce.entity.ReportSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportScheduleRepository extends JpaRepository<ReportSchedule, Long> {
    ReportSchedule findFirstByCode(String code);
}
