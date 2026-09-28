package com.example.ecommerce.controller;

import com.example.ecommerce.dto.PurchaseReturnItemDto;
import com.example.ecommerce.service.PurchaseReturnItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/purchaseReturnItems")
public class PurchaseReturnItemController {
    private final PurchaseReturnItemService service;

    public PurchaseReturnItemController(PurchaseReturnItemService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<PurchaseReturnItemDto> create(@RequestBody PurchaseReturnItemDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/<built-in function id>")
    public ResponseEntity<PurchaseReturnItemDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<PurchaseReturnItemDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/<built-in function id>")
    public ResponseEntity<PurchaseReturnItemDto> update(@PathVariable Long id, @RequestBody PurchaseReturnItemDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/<built-in function id>")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
