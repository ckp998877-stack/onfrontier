package com.example.ecommerce.controller;

import com.example.ecommerce.dto.CommissionDto;
import com.example.ecommerce.service.CommissionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/commissions")
public class CommissionController {
    private final CommissionService service;

    public CommissionController(CommissionService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CommissionDto> create(@RequestBody CommissionDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/<built-in function id>")
    public ResponseEntity<CommissionDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<CommissionDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/<built-in function id>")
    public ResponseEntity<CommissionDto> update(@PathVariable Long id, @RequestBody CommissionDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/<built-in function id>")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
