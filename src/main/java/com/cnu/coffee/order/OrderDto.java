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
        switch (status) {
            case "paid":
                if (orderStatus != OrderStatus.ORDER_ACCEPTED) throw new OrderException(OrderExceptionType.INVALID_STATUS);
                orderStatus = OrderStatus.PAYMENT_COMPLETE;
                break;
            case "prepared":
                if (orderStatus != OrderStatus.PAYMENT_COMPLETE) throw new OrderException(OrderExceptionType.INVALID_STATUS);
                orderStatus = OrderStatus.PREPARING_PRODUCT;
                break;
            case "started":
                if (orderStatus != OrderStatus.PREPARING_PRODUCT) throw new OrderException(OrderExceptionType.INVALID_STATUS);
                orderStatus = OrderStatus.START_DELIVERING;
                break;
            case "delivering":
                if (orderStatus != OrderStatus.START_DELIVERING) throw new OrderException(OrderExceptionType.INVALID_STATUS);
                orderStatus = OrderStatus.DELIVERING;
                break;
            case "delivered":
                if (orderStatus != OrderStatus.DELIVERING) throw new OrderException(OrderExceptionType.INVALID_STATUS);
                orderStatus = OrderStatus.DELIVERING_COMPLETE;
                break;
            case "returning":
                orderStatus = OrderStatus.RETURNING;
                break;
            default:
                throw new OrderException(OrderExceptionType.INVALID_INPUT);
        }
    }
}
