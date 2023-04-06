package com.cnu.coffee.order;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class OrderDto {

    Long orderId;
    Long productId;
    Long customerId;
    String orderStatus;
    int numberOfProducts;
    int totalPrice;

    public Order toEntity(OrderDto orderDto) {
        return Order.builder()
                .customerId(this.customerId)
                .productId(this.productId)
                .orderStatus(this.orderStatus)
                .numberOfProducts(this.numberOfProducts)
                .totalPrice(this.totalPrice)
                .build();
    }

    public void updateStatus(OrderStatus orderStatus){
        this.orderStatus = String.valueOf(orderStatus);
    }
    public void updateTotalPrice(int price) {
        this.totalPrice = price * this.numberOfProducts;
    }
}
