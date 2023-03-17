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

    private Long id = 0L;
    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public String insert(@RequestParam("name") String name, @RequestParam("price") int price) {
        return ps.insert(new Product(id++, name, price));
    }
}
