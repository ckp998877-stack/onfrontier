package com.example.ecommerce.controller;

import com.example.ecommerce.dto.ReturnOrderDto;
import com.example.ecommerce.service.ReturnOrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/returnOrders")
public class ReturnOrderController {
    private final ReturnOrderService service;

    public ReturnOrderController(ReturnOrderService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ReturnOrderDto> create(@RequestBody ReturnOrderDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/<built-in function id>")
    public ResponseEntity<ReturnOrderDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<ReturnOrderDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/<built-in function id>")
    public ResponseEntity<ReturnOrderDto> update(@PathVariable Long id, @RequestBody ReturnOrderDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/<built-in function id>")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
