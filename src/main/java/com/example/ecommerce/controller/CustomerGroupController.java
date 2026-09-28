package com.example.ecommerce.controller;

import com.example.ecommerce.dto.CustomerGroupDto;
import com.example.ecommerce.service.CustomerGroupService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/customerGroups")
public class CustomerGroupController {
    private final CustomerGroupService service;

    public CustomerGroupController(CustomerGroupService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CustomerGroupDto> create(@RequestBody CustomerGroupDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/<built-in function id>")
    public ResponseEntity<CustomerGroupDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<CustomerGroupDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/<built-in function id>")
    public ResponseEntity<CustomerGroupDto> update(@PathVariable Long id, @RequestBody CustomerGroupDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/<built-in function id>")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
