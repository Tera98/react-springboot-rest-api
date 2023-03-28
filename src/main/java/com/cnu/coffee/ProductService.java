package com.cnu.coffee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepository pr;

    public void save(ProductDto productdto){
        Product product = productdto.toEntity(productdto);
        pr.save(product);
    }
}
