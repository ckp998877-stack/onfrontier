package com.example.ecommerce.util;

public final class SortUtil {
    private SortUtil() {}
    public static boolean isEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }
}
