package com.cnu.coffee.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

import static com.cnu.coffee.common.GetNullPropertyNames.getNullPropertyNames;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

    Long orderId;
    Long productId;
    Long customerId;
    OrderStatus orderStatus;
    Integer numberOfProducts;
    Integer totalPrice;
    LocalDateTime orderCreatedAt = LocalDateTime.now();

    public Order toEntity() {
        return Order.builder()
                .orderId(this.orderId)
                .customerId(this.customerId)
                .productId(this.productId)
                .orderStatus(this.orderStatus)
                .numberOfProducts(this.numberOfProducts)
                .totalPrice(this.totalPrice)
                .orderCreatedAt(this.orderCreatedAt)
                .build();
    }

    public void updateStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void updateTotalPrice(int price) {
        this.totalPrice = price * this.numberOfProducts;
    }

    public OrderDto updateOrder(Order order) {
        OrderDto oldData = order.toDto();
        BeanUtils.copyProperties(this, oldData, getNullPropertyNames(this));
        return oldData;
    }
}

