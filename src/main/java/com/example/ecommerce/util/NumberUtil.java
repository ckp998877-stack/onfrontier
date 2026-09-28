package com.example.ecommerce.util;

public final class NumberUtil {
    private NumberUtil() {}
    public static boolean isEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }
}
