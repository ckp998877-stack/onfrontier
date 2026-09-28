package com.example.ecommerce.controller;

import com.example.ecommerce.dto.EmployeeRoleDto;
import com.example.ecommerce.service.EmployeeRoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/employeeRoles")
public class EmployeeRoleController {
    private final EmployeeRoleService service;

    public EmployeeRoleController(EmployeeRoleService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<EmployeeRoleDto> create(@RequestBody EmployeeRoleDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/<built-in function id>")
    public ResponseEntity<EmployeeRoleDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<EmployeeRoleDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/<built-in function id>")
    public ResponseEntity<EmployeeRoleDto> update(@PathVariable Long id, @RequestBody EmployeeRoleDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/<built-in function id>")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
