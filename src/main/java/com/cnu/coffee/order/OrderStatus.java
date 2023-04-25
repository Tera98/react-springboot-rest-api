package com.cnu.coffee.order;

import com.cnu.coffee.common.exception.OrderException;
import com.cnu.coffee.common.exception.OrderExceptionType;

public enum OrderStatus {

    ORDER_ACCEPTED,
    PAYMENT_COMPLETE,
    PREPARING_PRODUCT,
    START_DELIVERING,
    DELIVERING,
    DELIVERING_COMPLETE,
    RETURNING;

    public OrderStatus modifyStatus(String status) {
        switch (status) {
            case "paid":
                return OrderStatus.PAYMENT_COMPLETE;
            case "prepared":
                return OrderStatus.PREPARING_PRODUCT;
            case "started":
                return OrderStatus.START_DELIVERING;
            case "delivering":
                return OrderStatus.DELIVERING;
            case "delivered":
                return OrderStatus.DELIVERING_COMPLETE;
            case "returning":
                return OrderStatus.RETURNING;
            default:
                throw new OrderException(OrderExceptionType.INVALID_INPUT);
        }
    }

    public boolean canModifyStatus(String status) {
        switch (status) {
            case "paid":
                return this == OrderStatus.ORDER_ACCEPTED;
            case "prepared":
                return this == OrderStatus.PAYMENT_COMPLETE;
            case "started":
                return this == OrderStatus.PREPARING_PRODUCT;
            case "delivering":
                return this == OrderStatus.START_DELIVERING;
            case "delivered":
                return this == OrderStatus.DELIVERING;
            default:
                throw new OrderException(OrderExceptionType.INVALID_INPUT);
        }
    }
}
