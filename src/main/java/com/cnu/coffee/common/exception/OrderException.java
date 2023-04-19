package com.cnu.coffee.common.exception;

public class OrderException extends RuntimeException {
    private final OrderExceptionType orderExceptionType;

    public OrderException(OrderExceptionType orderExceptionType) {
        this.orderExceptionType = orderExceptionType;
    }

    @Override
    public String getMessage() {
        return orderExceptionType.getErrorMessage();
    }
}
