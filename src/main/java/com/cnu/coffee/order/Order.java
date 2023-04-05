package com.cnu.coffee.order;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    Long productId;
    Long customerId;
    String orderStatus;
    int numberOfProducts;
    int totalPrice;

    @Builder
    public Order(Long productId, Long customerId, String orderStatus, int numberOfProducts, int totalPrice) {
        this.productId = productId;
        this.customerId = customerId;
        this.orderStatus = orderStatus;
        this.numberOfProducts = numberOfProducts;
        this.totalPrice = totalPrice;
    }
}
