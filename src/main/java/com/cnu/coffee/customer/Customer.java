package com.cnu.coffee.customer;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
    public Customer(String customerName, String customerEmail, String customerPhoneNum, String customerAddress) {
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerPhoneNum = customerPhoneNum;
        this.customerAddress = customerAddress;
    }
}
