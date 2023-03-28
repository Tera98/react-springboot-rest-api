package com.cnu.coffee;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    int price;
    String origin;
    String customerName;
    String customerAddress;

    @Builder
    public Product(String name, int price, String origin, String customerName, String customerAddress) {
        this.name = name;
        this.price = price;
        this.origin = origin;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
    }
}
