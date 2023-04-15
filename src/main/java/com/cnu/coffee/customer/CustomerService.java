package com.cnu.coffee.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;
    public void saveCustomer(CustomerDto customerDto) {
        customerRepository.save(customerDto.toEntity());
    }
}
