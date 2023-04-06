package com.cnu.coffee.order;

import com.cnu.coffee.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ProductRepository productRepository;

    public void orderSave(OrderDto orderDto) {
        orderDto.updateStatus(OrderStatus.ORDER_ACCEPTED);
        orderDto.updateTotalPrice(productRepository.findById(orderDto.getProductId()).orElseThrow(() ->
                new EntityNotFoundException("User not found with id " + orderDto.getProductId())).getPrice());
        orderRepository.save(orderDto.toEntity(orderDto));
    }
}
