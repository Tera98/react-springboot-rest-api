package com.cnu.coffee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    ProductService ps;

    @GetMapping("/product")
    public void insert(@RequestParam("name") String name, @RequestParam("price") int price) {

        ProductDto productDto = ProductDto.builder()
                .name(name)
                .price(price)
                .build();

        ps.insert(productDto);
    }
}
