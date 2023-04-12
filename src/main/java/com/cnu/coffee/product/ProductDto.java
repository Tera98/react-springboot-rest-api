package com.cnu.coffee.product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;

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
                .productId(this.productId)
                .productName(this.productName)
                .productPrice(this.productPrice)
                .productOrigin(this.productOrigin)
                .build();
    }

    public Product updateProduct(Product product) {
        ProductDto oldData = product.toDto();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setSkipNullEnabled(true);
        modelMapper.map(this, oldData);
        return oldData.toEntity();
    }
}