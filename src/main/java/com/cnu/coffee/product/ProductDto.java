package com.cnu.coffee.product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import static com.cnu.coffee.common.GetNullPropertyNames.getNullPropertyNames;

@Getter
@Setter
@NoArgsConstructor
public class ProductDto {

    Long productId;
    String productName;
    Integer productPrice;
    String productOrigin;

    public Product toEntity() {
        return Product.builder()
                .productId(productId)
                .productName(productName)
                .productPrice(productPrice)
                .productOrigin(productOrigin)
                .build();
    }

    public Product updateProduct(Product product) {
        ProductDto oldData = product.toDto();
        BeanUtils.copyProperties(this, oldData, getNullPropertyNames(this));
        return oldData.toEntity();
    }
}