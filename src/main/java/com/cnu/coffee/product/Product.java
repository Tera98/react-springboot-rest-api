package com.cnu.coffee.product;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long productId;
    String productName;
    Integer productPrice;
    String productOrigin;

    @Builder
    public Product(Long productId, String productName, Integer productPrice, String productOrigin) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productOrigin = productOrigin;
    }

    public ProductDto toDto() {
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(this, productDto);
        return productDto;
    }
}
