package com.example.ecommerce.controller;

import com.example.ecommerce.dto.SalesItemDto;
import com.example.ecommerce.service.SalesItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/salesItems")
public class SalesItemController {
    private final SalesItemService service;

    public SalesItemController(SalesItemService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<SalesItemDto> create(@RequestBody SalesItemDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/<built-in function id>")
    public ResponseEntity<SalesItemDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<SalesItemDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/<built-in function id>")
    public ResponseEntity<SalesItemDto> update(@PathVariable Long id, @RequestBody SalesItemDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/<built-in function id>")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
