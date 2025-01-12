package com.cnu.coffee.order;

import com.cnu.coffee.common.exception.OrderException;
import com.cnu.coffee.common.exception.OrderExceptionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

import static com.cnu.coffee.common.GetNullPropertyNames.getNullPropertyNames;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

    Long orderId;
    Long productId;
    Long customerId;
    OrderStatus orderStatus;
    Integer numberOfProducts;
    Integer totalPrice;
    LocalDateTime orderCreatedAt;
    LocalDateTime orderUpdatedAt;

    public Order toEntity() {
        return Order.builder()
                .orderId(orderId)
                .customerId(customerId)
                .productId(productId)
                .orderStatus(orderStatus)
                .numberOfProducts(numberOfProducts)
                .totalPrice(totalPrice)
                .orderCreatedAt(orderCreatedAt)
                .orderUpdatedAt(LocalDateTime.now())
                .build();
    }

    public OrderDto updateOrder(Order order) {
        OrderDto oldData = order.toDto();
        BeanUtils.copyProperties(this, oldData, getNullPropertyNames(this));
        return oldData;
    }

    public void modifyStatus(String status) {
        if (!orderStatus.canModifyStatus(status)) throw new OrderException(OrderExceptionType.INVALID_STATUS);
        orderStatus = orderStatus.modifyStatus(status);
    }
}
