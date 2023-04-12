package com.cnu.coffee.order;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long orderId;
    Long productId;
    Long customerId;
    @Enumerated(value = EnumType.STRING)
    OrderStatus orderStatus;
    Integer numberOfProducts;
    Integer totalPrice;
    LocalDateTime orderCreatedAt;

    @Builder
    public Order(Long orderId, Long productId, Long customerId, OrderStatus orderStatus, Integer numberOfProducts, Integer totalPrice, LocalDateTime orderCreatedAt) {
        this.orderId = orderId;
        this.productId = productId;
        this.customerId = customerId;
        this.orderStatus = orderStatus;
        this.numberOfProducts = numberOfProducts;
        this.totalPrice = totalPrice;
        this.orderCreatedAt = orderCreatedAt;
    }

    public OrderDto toDto() {
        OrderDto orderDto = new OrderDto();
        BeanUtils.copyProperties(this, orderDto);
        return orderDto;
    }
}
