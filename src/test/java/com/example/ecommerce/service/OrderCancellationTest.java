package com.example.ecommerce.service;

import com.example.ecommerce.dto.OrderDto;
import com.example.ecommerce.entity.OrderItem;
import com.example.ecommerce.entity.Product;
import com.example.ecommerce.enums.OrderStatus;
import com.example.ecommerce.exception.OrderCancellationException;
import com.example.ecommerce.repository.OrderItemRepository;
import com.example.ecommerce.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class OrderCancellationTest {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private ProductRepository productRepository;

    private Product product(int initialStock) {
        Product p = new Product();
        p.setCode("P-" + initialStock + "-" + System.nanoTime());
        p.setName("Product");
        p.setStatus("ACTIVE");
        p.setStockQuantity(initialStock);
        return productRepository.save(p);
    }

    private OrderDto order(String status) {
        OrderDto dto = new OrderDto();
        dto.setCode("O-" + System.nanoTime());
        dto.setName("Order");
        dto.setStatus(status);
        return orderService.create(dto);
    }

    private void item(Long orderId, Long productId, int quantity) {
        OrderItem oi = new OrderItem();
        oi.setCode("OI-" + System.nanoTime());
        oi.setName("Item");
        oi.setStatus("ACTIVE");
        oi.setOrderId(orderId);
        oi.setProductId(productId);
        oi.setQuantity(quantity);
        orderItemRepository.save(oi);
    }

    @Test
    void cancelSetsStatusAndRestocksStock() {
        Product p = product(10);
        OrderDto created = order(OrderStatus.PENDING.name());
        item(created.getId(), p.getId(), 3);

        OrderDto cancelled = orderService.cancel(created.getId());

        assertEquals(OrderStatus.CANCELLED.name(), cancelled.getStatus());
        assertEquals(13, productRepository.findById(p.getId()).orElseThrow().getStockQuantity());
    }

    @Test
    void cancelRestocksEveryItemOnTheOrder() {
        Product first = product(5);
        Product second = product(0);
        OrderDto created = order(OrderStatus.PENDING.name());
        item(created.getId(), first.getId(), 2);
        item(created.getId(), second.getId(), 7);

        orderService.cancel(created.getId());

        assertEquals(7, productRepository.findById(first.getId()).orElseThrow().getStockQuantity());
        assertEquals(7, productRepository.findById(second.getId()).orElseThrow().getStockQuantity());
    }

    @Test
    void cancelDoesNotTouchStockOfOtherOrders() {
        Product mine = product(4);
        Product theirs = product(4);
        OrderDto target = order(OrderStatus.PENDING.name());
        OrderDto other = order(OrderStatus.PENDING.name());
        item(target.getId(), mine.getId(), 1);
        item(other.getId(), theirs.getId(), 9);

        orderService.cancel(target.getId());

        assertEquals(5, productRepository.findById(mine.getId()).orElseThrow().getStockQuantity());
        assertEquals(4, productRepository.findById(theirs.getId()).orElseThrow().getStockQuantity(),
                "stock for an unrelated order must not change");
    }

    @Test
    void cancellingAnAlreadyCancelledOrderIsRejected() {
        Product p = product(10);
        OrderDto created = order(OrderStatus.PENDING.name());
        item(created.getId(), p.getId(), 3);

        orderService.cancel(created.getId());

        OrderCancellationException ex = assertThrows(OrderCancellationException.class,
                () -> orderService.cancel(created.getId()));
        org.junit.jupiter.api.Assertions.assertTrue(ex.getMessage().contains("already cancelled"));

        assertEquals(13, productRepository.findById(p.getId()).orElseThrow().getStockQuantity(),
                "a rejected second cancel must not restock again");
    }

    @Test
    void cancellingAShippedOrderIsRejected() {
        Product p = product(10);
        OrderDto created = order(OrderStatus.SHIPPED.name());
        item(created.getId(), p.getId(), 3);

        assertThrows(OrderCancellationException.class, () -> orderService.cancel(created.getId()));

        assertEquals(10, productRepository.findById(p.getId()).orElseThrow().getStockQuantity(),
                "a shipped order must not restock");
    }

    @Test
    void cancellingACompletedOrderIsRejected() {
        OrderDto created = order(OrderStatus.COMPLETED.name());
        assertThrows(OrderCancellationException.class, () -> orderService.cancel(created.getId()));
    }

    @Test
    void cancellingUnknownOrderFailsAsInvalidArgument() {
        assertThrows(IllegalArgumentException.class, () -> orderService.cancel(999_999L));
    }

    @Test
    void cancelSucceedsWhenProductStockWasNeverSet() {
        Product p = new Product();
        p.setCode("P-null-" + System.nanoTime());
        p.setName("No stock");
        p.setStatus("ACTIVE");
        p = productRepository.save(p);

        OrderDto created = order(OrderStatus.PENDING.name());
        item(created.getId(), p.getId(), 6);

        orderService.cancel(created.getId());

        assertEquals(6, productRepository.findById(p.getId()).orElseThrow().getStockQuantity(),
                "null stock should be treated as zero");
    }

    @Test
    void cancelSucceedsForOrderWithNoItems() {
        OrderDto created = order(OrderStatus.PENDING.name());
        assertEquals(OrderStatus.CANCELLED.name(), orderService.cancel(created.getId()).getStatus());
    }
}
