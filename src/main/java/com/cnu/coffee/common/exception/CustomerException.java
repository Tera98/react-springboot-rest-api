package com.cnu.coffee.common.exception;

public class CustomerException extends RuntimeException {
    private final CustomerExceptionType customerExceptionType;

    public CustomerException(CustomerExceptionType customerExceptionType) {
        this.customerExceptionType = customerExceptionType;
    }

    @Override
    public String getMessage() {
        return customerExceptionType.getErrorMessage();
    }
}
