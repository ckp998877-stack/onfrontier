package com.example.ecommerce.controller;

import com.example.ecommerce.dto.LoyaltyTransactionDto;
import com.example.ecommerce.service.LoyaltyTransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/loyaltyTransactions")
public class LoyaltyTransactionController {
    private final LoyaltyTransactionService service;

    public LoyaltyTransactionController(LoyaltyTransactionService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<LoyaltyTransactionDto> create(@RequestBody LoyaltyTransactionDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/<built-in function id>")
    public ResponseEntity<LoyaltyTransactionDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<LoyaltyTransactionDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/<built-in function id>")
    public ResponseEntity<LoyaltyTransactionDto> update(@PathVariable Long id, @RequestBody LoyaltyTransactionDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/<built-in function id>")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
