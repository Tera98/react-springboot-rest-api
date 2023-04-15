package com.cnu.coffee.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @RequestMapping("/customer/save")
    public void customerSave(@RequestBody CustomerDto customerDto){
        customerService.customerSave(customerDto);
    }
}
