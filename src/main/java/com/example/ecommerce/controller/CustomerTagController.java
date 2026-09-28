package com.example.ecommerce.controller;

import com.example.ecommerce.dto.CustomerTagDto;
import com.example.ecommerce.service.CustomerTagService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/customerTags")
public class CustomerTagController {
    private final CustomerTagService service;

    public CustomerTagController(CustomerTagService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CustomerTagDto> create(@RequestBody CustomerTagDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerTagDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<CustomerTagDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerTagDto> update(@PathVariable Long id, @RequestBody CustomerTagDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
