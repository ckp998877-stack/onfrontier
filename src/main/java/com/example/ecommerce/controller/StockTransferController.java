package com.example.ecommerce.controller;

import com.example.ecommerce.dto.StockTransferDto;
import com.example.ecommerce.service.StockTransferService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/stockTransfers")
public class StockTransferController {
    private final StockTransferService service;

    public StockTransferController(StockTransferService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<StockTransferDto> create(@RequestBody StockTransferDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/<built-in function id>")
    public ResponseEntity<StockTransferDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<StockTransferDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/<built-in function id>")
    public ResponseEntity<StockTransferDto> update(@PathVariable Long id, @RequestBody StockTransferDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/<built-in function id>")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
