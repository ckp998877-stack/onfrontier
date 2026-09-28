package com.example.ecommerce.repository;

import com.example.ecommerce.entity.EmployeePermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeePermissionRepository extends JpaRepository<EmployeePermission, Long> {
    EmployeePermission findFirstByCode(String code);
}
