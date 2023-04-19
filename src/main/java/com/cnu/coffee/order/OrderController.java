package com.cnu.coffee.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping("/search/{orderId}") // 추후 기능 고도화
    public Order searchOrder(@PathVariable Long orderId) {
        return orderService.searchOrder(orderId);
    }

    @RequestMapping("/update")
    public void updateOrder(@RequestBody OrderDto orderDto) {
        orderService.updateOrder(orderDto);
    }

    @RequestMapping("/delete/{orderId}")
    public void deleteOrder(@PathVariable Long orderId) {
        orderService.deleteOrder(orderId);
    }

    @RequestMapping("/status/{orderId}&{status}")
    public void modifyOrderStatus(@PathVariable Long orderId, @PathVariable String status){
        orderService.modifyOrderStatus(orderId, status);
    }
}
