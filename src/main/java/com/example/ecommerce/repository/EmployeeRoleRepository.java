package com.example.ecommerce.repository;

import com.example.ecommerce.entity.EmployeeRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRoleRepository extends JpaRepository<EmployeeRole, Long> {
    EmployeeRole findFirstByCode(String code);
}
