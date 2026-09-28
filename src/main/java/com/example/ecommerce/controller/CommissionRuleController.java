package com.example.ecommerce.controller;

import com.example.ecommerce.dto.CommissionRuleDto;
import com.example.ecommerce.service.CommissionRuleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/commissionRules")
public class CommissionRuleController {
    private final CommissionRuleService service;

    public CommissionRuleController(CommissionRuleService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CommissionRuleDto> create(@RequestBody CommissionRuleDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/<built-in function id>")
    public ResponseEntity<CommissionRuleDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<CommissionRuleDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/<built-in function id>")
    public ResponseEntity<CommissionRuleDto> update(@PathVariable Long id, @RequestBody CommissionRuleDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/<built-in function id>")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
