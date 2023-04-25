package com.cnu.coffee.customer;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import static com.cnu.coffee.common.GetNullPropertyNames.getNullPropertyNames;

@Getter
@Setter
@NoArgsConstructor
public class CustomerDto {

    Long customerId;
    String loginId;
    String loginPw;
    String customerName;
    String customerEmail;
    String customerPhoneNum;
    String customerAddress;

    @Builder
    public CustomerDto(Long customerId, String loginId, String loginPw, String customerName, String customerEmail, String customerPhoneNum, String customerAddress) {
        this.customerId = customerId;
        this.loginId = loginId;
        this.loginPw = loginPw;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerPhoneNum = customerPhoneNum;
        this.customerAddress = customerAddress;
    }

    public Customer toEntity() {
        return Customer.builder()
                .customerId(customerId)
                .loginId(loginId)
                .loginPw(loginPw)
                .customerName(customerName)
                .customerEmail(customerEmail)
                .customerPhoneNum(customerPhoneNum)
                .customerAddress(customerAddress)
                .build();
    }
    public CustomerDto updateCustomer(Customer customer) {
        CustomerDto oldData = customer.toDto();
        BeanUtils.copyProperties(this, oldData, getNullPropertyNames(this));
        return oldData;
    }
}
