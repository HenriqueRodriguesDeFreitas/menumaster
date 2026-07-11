package com.paulo.menumaster.exception.custom;

public class EntityExistingException extends RuntimeException {
    public EntityExistingException(String message) {
        super(message);
    }
}
