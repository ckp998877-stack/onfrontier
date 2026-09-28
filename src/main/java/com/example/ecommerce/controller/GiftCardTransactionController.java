package com.example.ecommerce.controller;

import com.example.ecommerce.dto.GiftCardTransactionDto;
import com.example.ecommerce.service.GiftCardTransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/giftCardTransactions")
public class GiftCardTransactionController {
    private final GiftCardTransactionService service;

    public GiftCardTransactionController(GiftCardTransactionService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<GiftCardTransactionDto> create(@RequestBody GiftCardTransactionDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/<built-in function id>")
    public ResponseEntity<GiftCardTransactionDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<GiftCardTransactionDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/<built-in function id>")
    public ResponseEntity<GiftCardTransactionDto> update(@PathVariable Long id, @RequestBody GiftCardTransactionDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/<built-in function id>")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
