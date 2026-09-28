package com.example.ecommerce.controller;

import com.example.ecommerce.dto.PurchaseItemDto;
import com.example.ecommerce.service.PurchaseItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/purchaseItems")
public class PurchaseItemController {
    private final PurchaseItemService service;

    public PurchaseItemController(PurchaseItemService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<PurchaseItemDto> create(@RequestBody PurchaseItemDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PurchaseItemDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<PurchaseItemDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PurchaseItemDto> update(@PathVariable Long id, @RequestBody PurchaseItemDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
