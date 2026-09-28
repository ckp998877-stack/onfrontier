package com.example.ecommerce.controller;

import com.example.ecommerce.dto.SupplierContactDto;
import com.example.ecommerce.service.SupplierContactService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/supplierContacts")
public class SupplierContactController {
    private final SupplierContactService service;

    public SupplierContactController(SupplierContactService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<SupplierContactDto> create(@RequestBody SupplierContactDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SupplierContactDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<SupplierContactDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<SupplierContactDto> update(@PathVariable Long id, @RequestBody SupplierContactDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
