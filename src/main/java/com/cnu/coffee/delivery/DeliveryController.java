package com.cnu.coffee.delivery;

import com.cnu.coffee.order.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeliveryController {

    @Autowired
    DeliveryService deliveryService;

    @RequestMapping("/delivery/prepare")
    public void deliveryPrepare(@RequestBody OrderDto orderDto){
        deliveryService.deliveryPrepare(orderDto);
    }

    @RequestMapping("/delivery/start")
    public void deliveryStart(@RequestBody OrderDto orderDto) {
        deliveryService.deliveryStart(orderDto);
    }

    @RequestMapping("/delivery/delivering")
    public void delivering(@RequestBody OrderDto orderDto) {
        deliveryService.delivering(orderDto);
    }

    @RequestMapping("/delivery/complete")
    public void deliveryComplete(@RequestBody OrderDto orderDto) {
        deliveryService.deliveryComplete(orderDto);
    }
}
