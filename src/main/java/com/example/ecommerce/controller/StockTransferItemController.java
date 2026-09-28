package com.example.ecommerce.controller;

import com.example.ecommerce.dto.StockTransferItemDto;
import com.example.ecommerce.service.StockTransferItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/stockTransferItems")
public class StockTransferItemController {
    private final StockTransferItemService service;

    public StockTransferItemController(StockTransferItemService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<StockTransferItemDto> create(@RequestBody StockTransferItemDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/<built-in function id>")
    public ResponseEntity<StockTransferItemDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<StockTransferItemDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/<built-in function id>")
    public ResponseEntity<StockTransferItemDto> update(@PathVariable Long id, @RequestBody StockTransferItemDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/<built-in function id>")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
