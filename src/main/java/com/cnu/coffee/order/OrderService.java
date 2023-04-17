package com.cnu.coffee.order;

import com.cnu.coffee.order.exception.OrderException;
import com.cnu.coffee.order.exception.OrderExceptionType;
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

    public void saveOrder(OrderDto orderDto) {
        orderDto.setOrderStatus(OrderStatus.PAYMENT_COMPLETE); // 임시로 기본 값 PAYMENT_COMPLETE
        orderDto.setTotalPrice(productRepository.findById(orderDto.getProductId()).orElseThrow(() -> new EntityNotFoundException("User not found with id " + orderDto.getProductId()))
                .getProductPrice() * orderDto.getNumberOfProducts());
        orderRepository.save(orderDto.toEntity());
    }

    public void deleteOrder(OrderDto orderDto) {
        Order order = orderRepository.findById(orderDto.getOrderId()).orElseThrow(() -> new EntityNotFoundException("User not found with id " + orderDto.getOrderId()));
        OrderStatus orderStatus = order.getOrderStatus();
        if (orderStatus != OrderStatus.ORDER_ACCEPTED && orderStatus != OrderStatus.PAYMENT_COMPLETE) {
            throw new OrderException(OrderExceptionType.INVALID_STATUS);
        }
        orderRepository.delete(order);
    }

    public Order searchOrder(OrderDto orderDto) {
        return orderRepository.findById(orderDto.getOrderId()).orElseThrow(() -> new EntityNotFoundException("User not found with id " + orderDto.getOrderId()));
    }

    public void updateOrder(OrderDto orderDto) {
        Order oldData = orderRepository.findById(orderDto.getOrderId()).orElseThrow(() -> new EntityNotFoundException("User not found with id " + orderDto.getOrderId()));
        OrderStatus orderStatus = oldData.getOrderStatus();
        if (orderStatus != OrderStatus.ORDER_ACCEPTED && orderStatus != OrderStatus.PAYMENT_COMPLETE) {
            throw new OrderException(OrderExceptionType.INVALID_STATUS);
        }
        OrderDto newData = orderDto.updateOrder(oldData);
        newData.setTotalPrice(productRepository.findById(newData.getProductId()).orElseThrow(EntityNotFoundException::new)
                .getProductPrice() * newData.getNumberOfProducts());
        orderRepository.save(newData.toEntity());
    }
}