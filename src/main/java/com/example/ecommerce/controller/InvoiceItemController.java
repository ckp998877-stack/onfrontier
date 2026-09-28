package com.example.ecommerce.controller;

import com.example.ecommerce.dto.InvoiceItemDto;
import com.example.ecommerce.service.InvoiceItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/invoiceItems")
public class InvoiceItemController {
    private final InvoiceItemService service;

    public InvoiceItemController(InvoiceItemService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<InvoiceItemDto> create(@RequestBody InvoiceItemDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/<built-in function id>")
    public ResponseEntity<InvoiceItemDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<InvoiceItemDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/<built-in function id>")
    public ResponseEntity<InvoiceItemDto> update(@PathVariable Long id, @RequestBody InvoiceItemDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/<built-in function id>")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
