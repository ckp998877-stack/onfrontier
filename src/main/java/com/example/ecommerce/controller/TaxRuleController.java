package com.example.ecommerce.controller;

import com.example.ecommerce.dto.TaxRuleDto;
import com.example.ecommerce.service.TaxRuleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/taxRules")
public class TaxRuleController {
    private final TaxRuleService service;

    public TaxRuleController(TaxRuleService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<TaxRuleDto> create(@RequestBody TaxRuleDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaxRuleDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<TaxRuleDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaxRuleDto> update(@PathVariable Long id, @RequestBody TaxRuleDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
