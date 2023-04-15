package com.cnu.coffee.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping("/save")
    public void saveOrder(@RequestBody OrderDto orderDto) {
        orderService.saveOrder(orderDto);
    }

    @RequestMapping("/search")
    public Order searchOrder(@RequestBody OrderDto orderDto) {
        return orderService.searchOrder(orderDto);
    }

    @RequestMapping("/update")
    public void updateOrder(@RequestBody OrderDto orderDto) {
        orderService.updateOrder(orderDto);
    }

    @RequestMapping("/delete")
    public void deleteOrder(@RequestBody OrderDto orderDto) {
        orderService.deleteOrder(orderDto);
    }
}
