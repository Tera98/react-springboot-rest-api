package com.cnu.coffee;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class ProductDto {

    Long id;
    String name;
    int price;
    String origin;
    String customerName;
    String customerAddress;

    @Builder
    public ProductDto(String name, int price, String origin, String customerName, String customerAddress) {
        this.name = name;
        this.price = price;
        this.origin = origin;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
    }

    public Product toEntity(ProductDto productdto) {
        return Product.builder()
                .name(this.name)
                .price(this.price)
                .origin(this.origin)
                .customerName(this.customerName)
                .customerAddress(this.customerAddress)
                .build();
    }
}
