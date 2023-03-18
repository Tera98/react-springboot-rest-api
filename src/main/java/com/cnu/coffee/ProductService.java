package com.cnu.coffee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepository pr;

    public void insert(Product product){
        pr.insert(product);
    }

}
