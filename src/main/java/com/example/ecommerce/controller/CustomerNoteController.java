package com.example.ecommerce.controller;

import com.example.ecommerce.dto.CustomerNoteDto;
import com.example.ecommerce.service.CustomerNoteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/customerNotes")
public class CustomerNoteController {
    private final CustomerNoteService service;

    public CustomerNoteController(CustomerNoteService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CustomerNoteDto> create(@RequestBody CustomerNoteDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/<built-in function id>")
    public ResponseEntity<CustomerNoteDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<CustomerNoteDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/<built-in function id>")
    public ResponseEntity<CustomerNoteDto> update(@PathVariable Long id, @RequestBody CustomerNoteDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/<built-in function id>")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
