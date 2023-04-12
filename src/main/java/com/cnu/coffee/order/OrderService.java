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
        orderDto.updateStatus(OrderStatus.PAYMENT_COMPLETE); // 임시로 기본 값 PAYMENT_COMPLETE
        orderDto.updateTotalPrice(productRepository.findById(orderDto.getProductId()).orElseThrow(() ->
                new EntityNotFoundException("User not found with id " + orderDto.getProductId())).getProductPrice());
        orderRepository.save(orderDto.toEntity());
    }

    public void orderDelete(OrderDto orderDto) {
        orderRepository.deleteById(orderDto.getOrderId());
    }

    public Order orderSearch(OrderDto orderDto) {
        return orderRepository.findById(orderDto.getOrderId()).orElseThrow(() ->
                new EntityNotFoundException("User not found with id " + orderDto.getOrderId()));
    }

    public void orderUpdate(OrderDto orderDto) {
        Order oldData = orderRepository.findById(orderDto.getOrderId()).orElseThrow(()->
                new EntityNotFoundException("User not found with id" + orderDto.getOrderId()));
        OrderDto newData = orderDto.updateOrder(oldData);
        newData.updateTotalPrice(productRepository.findById(newData.getProductId()).orElseThrow(EntityNotFoundException::new).getProductPrice());
        orderRepository.save(newData.toEntity());
    }
}
