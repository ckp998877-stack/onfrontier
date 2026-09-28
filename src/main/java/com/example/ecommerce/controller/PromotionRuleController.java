package com.example.ecommerce.controller;

import com.example.ecommerce.dto.PromotionRuleDto;
import com.example.ecommerce.service.PromotionRuleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/promotionRules")
public class PromotionRuleController {
    private final PromotionRuleService service;

    public PromotionRuleController(PromotionRuleService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<PromotionRuleDto> create(@RequestBody PromotionRuleDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PromotionRuleDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<PromotionRuleDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PromotionRuleDto> update(@PathVariable Long id, @RequestBody PromotionRuleDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
