package com.example.ecommerce.util;

public final class CollectionUtil {
    private CollectionUtil() {}
    public static boolean isEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }
}
