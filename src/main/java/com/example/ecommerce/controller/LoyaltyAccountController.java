package com.example.ecommerce.controller;

import com.example.ecommerce.dto.LoyaltyAccountDto;
import com.example.ecommerce.service.LoyaltyAccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/loyaltyAccounts")
public class LoyaltyAccountController {
    private final LoyaltyAccountService service;

    public LoyaltyAccountController(LoyaltyAccountService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<LoyaltyAccountDto> create(@RequestBody LoyaltyAccountDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoyaltyAccountDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<LoyaltyAccountDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<LoyaltyAccountDto> update(@PathVariable Long id, @RequestBody LoyaltyAccountDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
