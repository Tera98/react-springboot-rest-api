package com.cnu.coffee.order;

import com.cnu.coffee.common.exception.OrderException;
import com.cnu.coffee.common.exception.OrderExceptionType;
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
        orderDto.setOrderStatus(OrderStatus.ORDER_ACCEPTED);
        orderDto.setTotalPrice(productRepository.findById(orderDto.getProductId()).orElseThrow(() -> new EntityNotFoundException("Order not found with id " + orderDto.getProductId()))
                .getProductPrice() * orderDto.getNumberOfProducts());
        orderRepository.save(orderDto.toEntity());
    }

    public Order searchOrder(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Order not found with id " + id));
    }

    public void updateOrder(OrderDto orderDto) {
        Order oldData = orderRepository.findById(orderDto.getOrderId()).orElseThrow(() -> new EntityNotFoundException("Order not found with id " + orderDto.getOrderId()));
        OrderStatus orderStatus = oldData.getOrderStatus();
        if (orderStatus != OrderStatus.ORDER_ACCEPTED && orderStatus != OrderStatus.PAYMENT_COMPLETE) {
            throw new OrderException(OrderExceptionType.INVALID_STATUS);
        }
        OrderDto newData = orderDto.updateOrder(oldData);
        newData.setTotalPrice(productRepository.findById(newData.getProductId()).orElseThrow(EntityNotFoundException::new)
                .getProductPrice() * newData.getNumberOfProducts());
        orderRepository.save(newData.toEntity());
    }

    public void deleteOrder(Long id) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Order not found with id " + id));
        OrderStatus orderStatus = order.getOrderStatus();
        if (orderStatus != OrderStatus.ORDER_ACCEPTED && orderStatus != OrderStatus.PAYMENT_COMPLETE) {
            throw new OrderException(OrderExceptionType.INVALID_STATUS);
        }
        orderRepository.delete(order);
    }

    public void modifyOrderStatus(Long id, String status) {
        OrderDto orderDto = orderRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Order not found with id " + id)).toDto();
        orderDto.modifyStatus(status);
        orderRepository.save(orderDto.toEntity());
    }
}