package com.cnu.coffee.delivery.exception;

public class DeliveryException extends RuntimeException {
    private final DeliveryExceptionType deliveryExceptionType;

    public DeliveryException(DeliveryExceptionType deliveryExceptionType) {
        this.deliveryExceptionType = deliveryExceptionType;
    }

    @Override
    public String getMessage() {
        return deliveryExceptionType.getErrorMessage();
    }
}
