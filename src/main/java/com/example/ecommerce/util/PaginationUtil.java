package com.example.ecommerce.util;

public final class PaginationUtil {
    private PaginationUtil() {}
    public static boolean isEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }
}
