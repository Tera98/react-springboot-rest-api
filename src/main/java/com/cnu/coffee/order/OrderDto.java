package com.cnu.coffee.order;

import lombok.Builder;
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

    @Builder
    public OrderDto(Long productId, Long customerId, String orderStatus, int numberOfProducts) {
        this.productId = productId;
        this.customerId = customerId;
        this.orderStatus = orderStatus;
        this.numberOfProducts = numberOfProducts;
    }

    public Order toEntity(OrderDto orderDto) {

        return Order.builder()
                .customerId(this.customerId)
                .productId(this.productId)
                .orderStatus(this.orderStatus)
                .numberOfProducts(this.numberOfProducts)
                .totalPrice(this.numberOfProducts * 2)
                .build();
    }
}
