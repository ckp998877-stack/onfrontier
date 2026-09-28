package com.example.ecommerce.controller;

import com.example.ecommerce.dto.DeliverySlotDto;
import com.example.ecommerce.service.DeliverySlotService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/deliverySlots")
public class DeliverySlotController {
    private final DeliverySlotService service;

    public DeliverySlotController(DeliverySlotService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<DeliverySlotDto> create(@RequestBody DeliverySlotDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/<built-in function id>")
    public ResponseEntity<DeliverySlotDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<DeliverySlotDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/<built-in function id>")
    public ResponseEntity<DeliverySlotDto> update(@PathVariable Long id, @RequestBody DeliverySlotDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/<built-in function id>")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
