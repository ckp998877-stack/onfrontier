package com.example.ecommerce.controller;

import com.example.ecommerce.dto.OrderStatusHistoryDto;
import com.example.ecommerce.service.OrderStatusHistoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/orderStatusHistorys")
public class OrderStatusHistoryController {
    private final OrderStatusHistoryService service;

    public OrderStatusHistoryController(OrderStatusHistoryService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<OrderStatusHistoryDto> create(@RequestBody OrderStatusHistoryDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderStatusHistoryDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<OrderStatusHistoryDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderStatusHistoryDto> update(@PathVariable Long id, @RequestBody OrderStatusHistoryDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
