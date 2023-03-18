package com.cnu.coffee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    ProductService ps;


    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public void insert(@RequestParam("name") String name, @RequestParam("price") int price) {
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        ps.insert(product);
    }
}
