package com.example.ecommerce.controller;

import com.example.ecommerce.dto.StoreLocationDto;
import com.example.ecommerce.service.StoreLocationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/storeLocations")
public class StoreLocationController {
    private final StoreLocationService service;

    public StoreLocationController(StoreLocationService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<StoreLocationDto> create(@RequestBody StoreLocationDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/<built-in function id>")
    public ResponseEntity<StoreLocationDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<StoreLocationDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/<built-in function id>")
    public ResponseEntity<StoreLocationDto> update(@PathVariable Long id, @RequestBody StoreLocationDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/<built-in function id>")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
