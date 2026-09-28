package com.example.ecommerce.util;

public final class AddressUtil {
    private AddressUtil() {}
    public static boolean isEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }
}
