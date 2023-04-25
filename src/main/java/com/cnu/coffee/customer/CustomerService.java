package com.cnu.coffee.customer;

import com.cnu.coffee.common.exception.CustomerException;
import com.cnu.coffee.common.exception.CustomerExceptionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public void saveCustomer(CustomerDto customerDto) {
        customerRepository.save(customerDto.toEntity());
    }

    public Customer searchCustomer(Long id) {
        return customerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Customer not found with id:" + id));
    }

    public void updateCustomer(CustomerDto customerDto) {
        Customer oldData = customerRepository.findById(customerDto.getCustomerId()).orElseThrow(() -> new EntityNotFoundException("Customer not found with id " + customerDto.getCustomerId()));
        if (!customerDto.loginId.equals(oldData.loginId)) {
            throw new CustomerException(CustomerExceptionType.INVALID_ID);
        } else if (!customerDto.loginPw.equals(oldData.loginPw)) {
            throw new CustomerException(CustomerExceptionType.INVALID_PW);
        }
        CustomerDto newData = customerDto.updateCustomer(oldData);
        customerRepository.save(newData.toEntity());
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
