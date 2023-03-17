package com.cnu.coffee;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class Product {


    long id;
    String name;
    int price;
    String origin;
    String customerName;
    String customerAddress;

    public Product(Long id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

}
