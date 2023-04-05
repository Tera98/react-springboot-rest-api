package com.cnu.coffee.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    OrderService os;
    @Autowired
    OrderRepository or;

    @RequestMapping("/order/save")
    public void orderSave(@RequestBody OrderDto orderDto) {
        os.orderSave(orderDto);
    }
}