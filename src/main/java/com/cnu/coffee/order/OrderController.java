package com.cnu.coffee.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping("/order/save")
    public void orderSave(@RequestBody OrderDto orderDto) {
        orderService.orderSave(orderDto);
    }

    @RequestMapping("/order/search")
    public Order orderSearch(@RequestBody OrderDto orderDto) {
        return orderService.orderSearch(orderDto);
    }

    @RequestMapping("/order/update")
    public void orderUpdate(@RequestBody OrderDto orderDto) {
        orderService.orderUpdate(orderDto);
    }

    @RequestMapping("/order/delete")
    public void orderDelete(@RequestBody OrderDto orderDto) {
        orderService.orderDelete(orderDto);
    }
}
