package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.OrderDto;
import com.example.ecommerce.entity.Order;
import com.example.ecommerce.entity.OrderItem;
import com.example.ecommerce.entity.Product;
import com.example.ecommerce.enums.OrderStatus;
import com.example.ecommerce.exception.OrderCancellationException;
import com.example.ecommerce.repository.OrderItemRepository;
import com.example.ecommerce.repository.OrderRepository;
import com.example.ecommerce.repository.ProductRepository;
import com.example.ecommerce.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository repository;
    private final OrderItemRepository orderItemRepository;
    private final ProductRepository productRepository;

    public OrderServiceImpl(OrderRepository repository,
                            OrderItemRepository orderItemRepository,
                            ProductRepository productRepository) {
        this.repository = repository;
        this.orderItemRepository = orderItemRepository;
        this.productRepository = productRepository;
    }

    @Override
    public OrderDto create(OrderDto dto) {
        Order entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public OrderDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("Order not found: " + id));
    }

    @Override
    public List<OrderDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public OrderDto update(Long id, OrderDto dto) {
        Order entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Order not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    /**
     * Cancels an order and returns its item quantities to product stock.
     *
     * <p>Transactional so the status change and every stock increment commit
     * together - a partial restock would silently corrupt inventory.
     */
    @Override
    @Transactional
    public OrderDto cancel(Long id) {
        Order order = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Order not found: " + id));

        assertCancellable(order);

        for (OrderItem item : orderItemRepository.findByOrderId(order.getId())) {
            restock(item);
        }

        order.setStatus(OrderStatus.CANCELLED.name());
        order.setUpdatedAt(LocalDateTime.now());
        return toDto(repository.save(order));
    }

    /**
     * Rejects orders that are already cancelled or have moved to shipping.
     *
     * <p>{@code status} is a free-text column, so a value outside
     * {@link OrderStatus} is treated as not-yet-shipped and allowed through;
     * that keeps pre-existing rows (and clients using their own status names)
     * cancellable as they were before.
     */
    private void assertCancellable(Order order) {
        Optional<OrderStatus> status = parseStatus(order.getStatus());
        if (status.isEmpty()) {
            return;
        }

        if (status.get() == OrderStatus.CANCELLED) {
            throw new OrderCancellationException("Order " + order.getId() + " is already cancelled");
        }
        if (!status.get().isCancellable()) {
            throw new OrderCancellationException(
                    "Order " + order.getId() + " cannot be cancelled once it is " + status.get().name());
        }
    }

    private Optional<OrderStatus> parseStatus(String status) {
        if (status == null) {
            return Optional.empty();
        }
        try {
            return Optional.of(OrderStatus.valueOf(status.trim().toUpperCase()));
        } catch (IllegalArgumentException ex) {
            return Optional.empty();
        }
    }

    /**
     * Adds a cancelled item's quantity back to its product's stock. Items with
     * no product link or no quantity are skipped rather than failing the
     * cancellation.
     */
    private void restock(OrderItem item) {
        if (item.getProductId() == null || item.getQuantity() == null) {
            return;
        }

        Product product = productRepository.findById(item.getProductId()).orElse(null);
        if (product == null) {
            return;
        }

        int current = product.getStockQuantity() == null ? 0 : product.getStockQuantity();
        product.setStockQuantity(current + item.getQuantity());
        product.setUpdatedAt(LocalDateTime.now());
        productRepository.save(product);
    }

    private Order toEntity(OrderDto dto) {
        Order e = new Order();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private OrderDto toDto(Order e) {
        OrderDto d = new OrderDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
