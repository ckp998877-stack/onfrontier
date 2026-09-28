package com.example.ecommerce.controller;

import com.example.ecommerce.dto.ProductPriceDto;
import com.example.ecommerce.service.ProductPriceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/productPrices")
public class ProductPriceController {
    private final ProductPriceService service;

    public ProductPriceController(ProductPriceService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ProductPriceDto> create(@RequestBody ProductPriceDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/<built-in function id>")
    public ResponseEntity<ProductPriceDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<ProductPriceDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/<built-in function id>")
    public ResponseEntity<ProductPriceDto> update(@PathVariable Long id, @RequestBody ProductPriceDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/<built-in function id>")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
