package com.example.ecommerce.controller;

import com.example.ecommerce.dto.SavedAddressDto;
import com.example.ecommerce.service.SavedAddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/savedAddresss")
public class SavedAddressController {
    private final SavedAddressService service;

    public SavedAddressController(SavedAddressService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<SavedAddressDto> create(@RequestBody SavedAddressDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SavedAddressDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<SavedAddressDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<SavedAddressDto> update(@PathVariable Long id, @RequestBody SavedAddressDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
