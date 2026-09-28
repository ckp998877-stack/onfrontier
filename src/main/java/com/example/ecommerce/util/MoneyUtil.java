package com.example.ecommerce.util;

public final class MoneyUtil {
    private MoneyUtil() {}
    public static boolean isEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }
}
