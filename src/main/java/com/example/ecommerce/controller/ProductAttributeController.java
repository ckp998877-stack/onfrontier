package com.example.ecommerce.controller;

import com.example.ecommerce.dto.ProductAttributeDto;
import com.example.ecommerce.service.ProductAttributeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/productAttributes")
public class ProductAttributeController {
    private final ProductAttributeService service;

    public ProductAttributeController(ProductAttributeService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ProductAttributeDto> create(@RequestBody ProductAttributeDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/<built-in function id>")
    public ResponseEntity<ProductAttributeDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<ProductAttributeDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/<built-in function id>")
    public ResponseEntity<ProductAttributeDto> update(@PathVariable Long id, @RequestBody ProductAttributeDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/<built-in function id>")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
