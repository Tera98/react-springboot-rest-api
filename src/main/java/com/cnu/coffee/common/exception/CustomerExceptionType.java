package com.cnu.coffee.common.exception;

public enum CustomerExceptionType {

    INVALID_ID("Invalid customer id"),
    INVALID_PW("Invalid customer password");

    private final String errorMessage;

    CustomerExceptionType(String message) {
        this.errorMessage = message;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}

