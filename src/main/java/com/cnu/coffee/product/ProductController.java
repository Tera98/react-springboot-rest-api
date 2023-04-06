package com.cnu.coffee.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    ProductService ps;
    @Autowired
    ProductRepository pr;

    @RequestMapping("/product/save")
    public void productSave(@RequestBody ProductDto productDto) {
        ps.productSave(productDto);
    }

    @RequestMapping("/product/update")
    public void productUpdate(@RequestBody ProductDto productDto) {
        ps.productUpdate(productDto);
    }

    @RequestMapping("/product/search")
    public Optional<Product> productSearch(@RequestBody ProductDto productDto){
        return Optional.ofNullable(pr.findById(productDto.getId()).orElseThrow(() ->
                new EntityNotFoundException("User not found with id " + productDto.getId())));
    }

    @RequestMapping("/product/delete")
    public void productDelete(@RequestBody ProductDto productDto){
        ps.productDelete(productDto);
    }
}
