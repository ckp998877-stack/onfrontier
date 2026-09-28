package com.example.ecommerce.controller;

import com.example.ecommerce.dto.TaxRateDto;
import com.example.ecommerce.service.TaxRateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/taxRates")
public class TaxRateController {
    private final TaxRateService service;

    public TaxRateController(TaxRateService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<TaxRateDto> create(@RequestBody TaxRateDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaxRateDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<TaxRateDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaxRateDto> update(@PathVariable Long id, @RequestBody TaxRateDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
