package com.example.ecommerce.enums;

/**
 * Order lifecycle states.
 *
 * <p>New values are appended rather than reordered so any persisted ordinals
 * stay valid. {@code Order.status} remains a String column, so these names are
 * used for comparison rather than as a JPA-mapped type.
 */
public enum OrderStatus {
    ACTIVE, INACTIVE, PENDING, COMPLETED, SHIPPED, CANCELLED;

    /**
     * Cancellation is only permitted before the order leaves the warehouse.
     * Anything shipped, completed, or already cancelled is final.
     */
    public boolean isCancellable() {
        return this == ACTIVE || this == INACTIVE || this == PENDING;
    }
}
