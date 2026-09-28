package com.example.ecommerce.controller;

import com.example.ecommerce.dto.BudgetLineDto;
import com.example.ecommerce.service.BudgetLineService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/budgetLines")
public class BudgetLineController {
    private final BudgetLineService service;

    public BudgetLineController(BudgetLineService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<BudgetLineDto> create(@RequestBody BudgetLineDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BudgetLineDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<BudgetLineDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<BudgetLineDto> update(@PathVariable Long id, @RequestBody BudgetLineDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
