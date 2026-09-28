package com.example.ecommerce.controller;

import com.example.ecommerce.dto.EmployeePermissionDto;
import com.example.ecommerce.service.EmployeePermissionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/employeePermissions")
public class EmployeePermissionController {
    private final EmployeePermissionService service;

    public EmployeePermissionController(EmployeePermissionService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<EmployeePermissionDto> create(@RequestBody EmployeePermissionDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/<built-in function id>")
    public ResponseEntity<EmployeePermissionDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<EmployeePermissionDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/<built-in function id>")
    public ResponseEntity<EmployeePermissionDto> update(@PathVariable Long id, @RequestBody EmployeePermissionDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/<built-in function id>")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
