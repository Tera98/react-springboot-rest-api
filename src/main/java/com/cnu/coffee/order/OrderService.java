package com.cnu.coffee.order;

import com.cnu.coffee.product.Product;
import com.cnu.coffee.product.ProductDto;
import com.cnu.coffee.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    OrderRepository or;

    public void orderSave(OrderDto orderDto) {
        or.save(orderDto.toEntity(orderDto));
    }

}
