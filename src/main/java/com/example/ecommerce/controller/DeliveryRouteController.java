package com.example.ecommerce.controller;

import com.example.ecommerce.dto.DeliveryRouteDto;
import com.example.ecommerce.service.DeliveryRouteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/deliveryRoutes")
public class DeliveryRouteController {
    private final DeliveryRouteService service;

    public DeliveryRouteController(DeliveryRouteService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<DeliveryRouteDto> create(@RequestBody DeliveryRouteDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/<built-in function id>")
    public ResponseEntity<DeliveryRouteDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<DeliveryRouteDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/<built-in function id>")
    public ResponseEntity<DeliveryRouteDto> update(@PathVariable Long id, @RequestBody DeliveryRouteDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/<built-in function id>")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
