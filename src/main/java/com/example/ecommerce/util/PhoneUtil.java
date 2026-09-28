package com.example.ecommerce.util;

public final class PhoneUtil {
    private PhoneUtil() {}
    public static boolean isEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }
}
