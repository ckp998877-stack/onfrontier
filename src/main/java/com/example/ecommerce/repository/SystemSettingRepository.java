package com.example.ecommerce.repository;

import com.example.ecommerce.entity.SystemSetting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemSettingRepository extends JpaRepository<SystemSetting, Long> {
    SystemSetting findFirstByCode(String code);
}
