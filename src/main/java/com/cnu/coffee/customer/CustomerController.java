package com.cnu.coffee.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @RequestMapping("/save")
    public void saveCustomer(@RequestBody CustomerDto customerDto){
        customerService.saveCustomer(customerDto);
    }

    @RequestMapping("/search/{id}")
    public Customer searchCustomer(@PathVariable Long id){
        return customerService.searchCustomer(id);
    }
    @RequestMapping("/update")
    public void updateOrder(@RequestBody CustomerDto customerDto) {
        customerService.updateCustomer(customerDto);
    }

    @RequestMapping("/delete/{id}")
    public void deleteOrder(@PathVariable Long id) {
        customerService.deleteCustomer(id);
    }

}
