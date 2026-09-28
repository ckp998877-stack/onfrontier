package com.example.ecommerce.controller;

import com.example.ecommerce.dto.InventoryTransactionDto;
import com.example.ecommerce.service.InventoryTransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/inventoryTransactions")
public class InventoryTransactionController {
    private final InventoryTransactionService service;

    public InventoryTransactionController(InventoryTransactionService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<InventoryTransactionDto> create(@RequestBody InventoryTransactionDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/<built-in function id>")
    public ResponseEntity<InventoryTransactionDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<InventoryTransactionDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/<built-in function id>")
    public ResponseEntity<InventoryTransactionDto> update(@PathVariable Long id, @RequestBody InventoryTransactionDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/<built-in function id>")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
