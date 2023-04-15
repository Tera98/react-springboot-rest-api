package com.cnu.coffee.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

    Long orderId;
    Long productId;
    Long customerId;
    String orderStatus;
    Integer numberOfProducts;
    Integer totalPrice;

    public Order toEntity() {
        return Order.builder()
                .orderId(this.orderId)
                .customerId(this.customerId)
                .productId(this.productId)
                .orderStatus(this.orderStatus)
                .numberOfProducts(this.numberOfProducts)
                .totalPrice(this.totalPrice)
                .build();
    }

    public void updateStatus(OrderStatus orderStatus) {
        this.orderStatus = String.valueOf(orderStatus);
    }

    public void updateTotalPrice(int price) {
        this.totalPrice = price * this.numberOfProducts;
    }

    public OrderDto updateOrder(Order order) {
        OrderDto oldData = order.toDto();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setSkipNullEnabled(true);
        modelMapper.map(this, oldData);
        return oldData;
    }
}
