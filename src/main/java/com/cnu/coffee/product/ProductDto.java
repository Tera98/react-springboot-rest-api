package com.cnu.coffee.product;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Optional;


@Getter
@NoArgsConstructor
public class ProductDto {

    Long id;
    String name;
    Integer price;
    String origin;

    @Builder
    public ProductDto(Long id, String name, Integer price, String origin) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.origin = origin;
    }

    public Product toEntity(ProductDto productdto) {
        return Product.builder()
                .id(this.id)
                .name(this.name)
                .price(this.price)
                .origin(this.origin)
                .build();
    }
}