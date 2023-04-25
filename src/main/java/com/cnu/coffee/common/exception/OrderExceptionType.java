package com.cnu.coffee.common.exception;

public enum OrderExceptionType {

    INVALID_STATUS("Invalid orderStatus"),
    INVALID_INPUT("Invalid input status");

    private final String errorMessage;

    OrderExceptionType(String message) {
        this.errorMessage = message;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}

