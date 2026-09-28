package com.example.ecommerce.controller;

import com.example.ecommerce.dto.ReturnItemDto;
import com.example.ecommerce.service.ReturnItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/returnItems")
public class ReturnItemController {
    private final ReturnItemService service;

    public ReturnItemController(ReturnItemService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ReturnItemDto> create(@RequestBody ReturnItemDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/<built-in function id>")
    public ResponseEntity<ReturnItemDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<ReturnItemDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/<built-in function id>")
    public ResponseEntity<ReturnItemDto> update(@PathVariable Long id, @RequestBody ReturnItemDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/<built-in function id>")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
