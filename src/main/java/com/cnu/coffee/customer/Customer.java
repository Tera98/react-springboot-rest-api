package com.cnu.coffee.customer;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long customerId;
    String customerName;
    String customerEmail;
    String customerPhoneNum;
    String customerAddress;

    @Builder
    public Customer(Long customerId, String customerName, String customerEmail, String customerPhoneNum, String customerAddress) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerPhoneNum = customerPhoneNum;
        this.customerAddress = customerAddress;
    }

    public CustomerDto toDto() {
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(this, customerDto);
        return customerDto;
    }
}
