package com.example.ecommerce.controller;

import com.example.ecommerce.dto.WarehouseStockDto;
import com.example.ecommerce.service.WarehouseStockService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/warehouseStocks")
public class WarehouseStockController {
    private final WarehouseStockService service;

    public WarehouseStockController(WarehouseStockService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<WarehouseStockDto> create(@RequestBody WarehouseStockDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/<built-in function id>")
    public ResponseEntity<WarehouseStockDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<WarehouseStockDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/<built-in function id>")
    public ResponseEntity<WarehouseStockDto> update(@PathVariable Long id, @RequestBody WarehouseStockDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/<built-in function id>")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
