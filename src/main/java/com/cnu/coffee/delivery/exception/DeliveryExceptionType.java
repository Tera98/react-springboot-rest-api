package com.cnu.coffee.delivery.exception;

public enum DeliveryExceptionType {

    INVALID_STATUS("Invalid orderStatus");

    private final String errorMessage;

    DeliveryExceptionType(String message) {
        this.errorMessage = message;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}

