package com.example.ecommerce.util;

public final class DateUtil {
    private DateUtil() {}
    public static boolean isEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }
}
