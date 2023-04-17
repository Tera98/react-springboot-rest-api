package com.cnu.coffee.order.exception;

public enum OrderExceptionType {

    INVALID_STATUS("Invalid orderStatus");

    private final String errorMessage;

    OrderExceptionType(String message) {
        this.errorMessage = message;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}

