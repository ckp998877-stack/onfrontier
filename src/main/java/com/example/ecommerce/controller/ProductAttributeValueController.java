package com.example.ecommerce.controller;

import com.example.ecommerce.dto.ProductAttributeValueDto;
import com.example.ecommerce.service.ProductAttributeValueService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/productAttributeValues")
public class ProductAttributeValueController {
    private final ProductAttributeValueService service;

    public ProductAttributeValueController(ProductAttributeValueService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ProductAttributeValueDto> create(@RequestBody ProductAttributeValueDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductAttributeValueDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<ProductAttributeValueDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductAttributeValueDto> update(@PathVariable Long id, @RequestBody ProductAttributeValueDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
