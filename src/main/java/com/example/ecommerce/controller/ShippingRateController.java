package com.example.ecommerce.controller;

import com.example.ecommerce.dto.ShippingRateDto;
import com.example.ecommerce.service.ShippingRateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/shippingRates")
public class ShippingRateController {
    private final ShippingRateService service;

    public ShippingRateController(ShippingRateService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ShippingRateDto> create(@RequestBody ShippingRateDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShippingRateDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<ShippingRateDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ShippingRateDto> update(@PathVariable Long id, @RequestBody ShippingRateDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
