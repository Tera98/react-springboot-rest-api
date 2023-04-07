package com.cnu.coffee.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import javax.persistence.*;

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
    String orderStatus;
    Integer numberOfProducts;
    Integer totalPrice;

    @Builder
    public Order(Long orderId, Long productId, Long customerId, String orderStatus, int numberOfProducts, int totalPrice) {
        this.orderId = orderId;
        this.productId = productId;
        this.customerId = customerId;
        this.orderStatus = orderStatus;
        this.numberOfProducts = numberOfProducts;
        this.totalPrice = totalPrice;
    }

    public OrderDto toDto() {
        ModelMapper modelMapper = new ModelMapper();
        OrderDto orderDto = new OrderDto();
        modelMapper.map(this, orderDto);
        return orderDto;
    }
}
