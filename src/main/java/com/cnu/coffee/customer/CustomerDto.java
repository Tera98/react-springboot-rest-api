package com.cnu.coffee.customer;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CustomerDto {

    Long customerId;
    String customerName;
    String customerEmail;
    String customerPhoneNum;
    String customerAddress;

    @Builder
    public CustomerDto(Long customerId, String customerName, String customerEmail, String customerPhoneNum, String customerAddress) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerPhoneNum = customerPhoneNum;
        this.customerAddress = customerAddress;
    }

    public Customer toEntity() {
        return Customer.builder()
                .customerId(customerId)
                .customerName(customerName)
                .customerEmail(customerEmail)
                .customerPhoneNum(customerPhoneNum)
                .customerAddress(customerAddress)
                .build();
    }
}
