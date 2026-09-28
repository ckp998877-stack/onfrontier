package com.example.ecommerce.controller;

import com.example.ecommerce.dto.DeliveryAgentDto;
import com.example.ecommerce.service.DeliveryAgentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/deliveryAgents")
public class DeliveryAgentController {
    private final DeliveryAgentService service;

    public DeliveryAgentController(DeliveryAgentService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<DeliveryAgentDto> create(@RequestBody DeliveryAgentDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/<built-in function id>")
    public ResponseEntity<DeliveryAgentDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<DeliveryAgentDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/<built-in function id>")
    public ResponseEntity<DeliveryAgentDto> update(@PathVariable Long id, @RequestBody DeliveryAgentDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/<built-in function id>")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
