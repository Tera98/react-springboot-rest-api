package com.cnu.coffee.product;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    Integer price;
    String origin;

    @Builder
    public Product(Long id, String name, Integer price, String origin) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.origin = origin;
    }

    public Product updateProduct(Product product, ProductDto productDto){
        return Product.builder()
                .id(product.getId())
                .name(productDto.getName() != null ? productDto.getName() : product.getName())
                .price(productDto.getPrice() != null ? productDto.getPrice() : product.getPrice())
                .origin(productDto.getOrigin() != null ? productDto.getOrigin() : product.getOrigin())
                .build();
    }
}
