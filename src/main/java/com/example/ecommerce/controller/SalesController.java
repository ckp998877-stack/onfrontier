package com.example.ecommerce.controller;

import com.example.ecommerce.dto.SalesDto;
import com.example.ecommerce.service.SalesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/saless")
public class SalesController {
    private final SalesService service;

    public SalesController(SalesService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<SalesDto> create(@RequestBody SalesDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SalesDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<SalesDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<SalesDto> update(@PathVariable Long id, @RequestBody SalesDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
