package com.cnu.coffee.customer;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CustomerDto {

    String customerName;
    String customerEmail;
    String customerPhoneNum;
    String customerAddress;
    public Customer toEntity(CustomerDto customerDto){
        return Customer.builder()
                .customerName(this.customerName)
                .customerEmail(this.customerEmail)
                .customerPhoneNum(this.customerPhoneNum)
                .customerAddress(this.customerAddress)
                .build();
    }
}
