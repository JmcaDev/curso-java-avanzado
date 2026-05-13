package com.devtalles.proyecto.product.utils;

import com.devtalles.proyecto.product.exceptions.InvalidProductException;

public class Validates {
    public static <T extends Number> void validateNumber(T value, String message) throws InvalidProductException {
        if(value == null){
            throw new InvalidProductException(message);
        }
    }

    public static <T> void ValidateObject(T obj, String message) throws InvalidProductException {
        if(obj == null){
            throw new InvalidProductException(message);
        }
    }

    public static void validateText(String value, String message) throws InvalidProductException {
        if(value == null || value.isEmpty()){
            throw new InvalidProductException(message);
        }
    }
}
