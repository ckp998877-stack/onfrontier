package com.example.ecommerce.controller;

import com.example.ecommerce.dto.FaqDto;
import com.example.ecommerce.service.FaqService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/faqs")
public class FaqController {
    private final FaqService service;

    public FaqController(FaqService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<FaqDto> create(@RequestBody FaqDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FaqDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<FaqDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<FaqDto> update(@PathVariable Long id, @RequestBody FaqDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
