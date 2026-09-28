package com.example.ecommerce.util;

public final class JsonUtil {
    private JsonUtil() {}
    public static boolean isEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }
}
