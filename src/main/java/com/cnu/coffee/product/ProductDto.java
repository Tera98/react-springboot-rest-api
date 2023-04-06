package com.cnu.coffee.product;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductDto {

    Long id;
    String name;
    Integer price;
    String origin;

    public Product toEntity(ProductDto productdto) {
        return Product.builder()
                .id(this.id)
                .name(this.name)
                .price(this.price)
                .origin(this.origin)
                .build();
    }
}