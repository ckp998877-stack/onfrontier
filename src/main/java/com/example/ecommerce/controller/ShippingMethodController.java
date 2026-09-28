package com.example.ecommerce.controller;

import com.example.ecommerce.dto.ShippingMethodDto;
import com.example.ecommerce.service.ShippingMethodService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/shippingMethods")
public class ShippingMethodController {
    private final ShippingMethodService service;

    public ShippingMethodController(ShippingMethodService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ShippingMethodDto> create(@RequestBody ShippingMethodDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShippingMethodDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<ShippingMethodDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ShippingMethodDto> update(@PathVariable Long id, @RequestBody ShippingMethodDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
