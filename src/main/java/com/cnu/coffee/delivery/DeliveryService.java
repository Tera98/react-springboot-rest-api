package com.cnu.coffee.delivery;

import com.cnu.coffee.delivery.exception.DeliveryException;
import com.cnu.coffee.delivery.exception.DeliveryExceptionType;
import com.cnu.coffee.order.OrderDto;
import com.cnu.coffee.order.OrderRepository;
import com.cnu.coffee.order.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class DeliveryService {

    @Autowired
    OrderRepository orderRepository;

    public void deliveryPrepare(OrderDto orderDto) {
        OrderDto data = orderRepository.findById(orderDto.getOrderId()).orElseThrow(() ->
                new EntityNotFoundException("User not found with id" + orderDto.getOrderId())).toDto();
        if (data.getOrderStatus() != OrderStatus.PAYMENT_COMPLETE) {
            throw new DeliveryException(DeliveryExceptionType.INVALID_STATUS);
        }
        data.setOrderStatus(OrderStatus.PREPARING_PRODUCT);
        orderRepository.save(data.toEntity());
    }

    public void deliveryStart(OrderDto orderDto) {
        OrderDto data = orderRepository.findById(orderDto.getOrderId()).orElseThrow(() ->
                new EntityNotFoundException("User not found with id" + orderDto.getOrderId())).toDto();
        if (data.getOrderStatus() != OrderStatus.PREPARING_PRODUCT) {
            throw new DeliveryException(DeliveryExceptionType.INVALID_STATUS);
        }
        data.setOrderStatus(OrderStatus.START_DELIVERING);
        orderRepository.save(data.toEntity());
    }

    public void delivering(OrderDto orderDto) {
        OrderDto data = orderRepository.findById(orderDto.getOrderId()).orElseThrow(() ->
                new EntityNotFoundException("User not found with id" + orderDto.getOrderId())).toDto();
        if (data.getOrderStatus() != OrderStatus.START_DELIVERING) {
            throw new DeliveryException(DeliveryExceptionType.INVALID_STATUS);
        }
        data.setOrderStatus(OrderStatus.DELIVERING);
        orderRepository.save(data.toEntity());
    }

    public void deliveryComplete(OrderDto orderDto) {
        OrderDto data = orderRepository.findById(orderDto.getOrderId()).orElseThrow(() ->
                new EntityNotFoundException("User not found with id" + orderDto.getOrderId())).toDto();
        if (data.getOrderStatus() != OrderStatus.DELIVERING) {
            throw new DeliveryException(DeliveryExceptionType.INVALID_STATUS);
        }
        data.setOrderStatus(OrderStatus.DELIVERING_COMPLETE);
        orderRepository.save(data.toEntity());
    }
}
