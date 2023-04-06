package com.cnu.coffee.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class ProductService {

    @Autowired
    ProductRepository pr;

    public void productSave(ProductDto productdto) {
        Product product = productdto.toEntity(productdto);
        pr.save(product);
    }

    public void productUpdate(ProductDto productDto) {
        Product product = pr.findById(productDto.getId()).orElseThrow(() ->
                new EntityNotFoundException("User not found with id " + productDto.getId()));
        pr.save(product.updateProduct(product,productDto));
    }

    public void productDelete(ProductDto productDto) {
        pr.deleteById(productDto.getId());
    }
}
