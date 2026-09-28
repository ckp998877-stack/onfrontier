package com.example.ecommerce.repository;

import com.example.ecommerce.entity.SessionRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRecordRepository extends JpaRepository<SessionRecord, Long> {
    SessionRecord findFirstByCode(String code);
}
