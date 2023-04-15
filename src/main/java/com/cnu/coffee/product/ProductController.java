package com.cnu.coffee.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping("/product/save")
    public void productSave(@RequestBody ProductDto productDto) {
        productService.productSave(productDto);
    }

    @RequestMapping("/product/update")
    public void productUpdate(@RequestBody ProductDto productDto) {
        productService.productUpdate(productDto);
    }

    @RequestMapping("/product/search")
    public Optional<Product> productSearch(@RequestBody ProductDto productDto){
        return productService.productSearch(productDto);
    }

    @RequestMapping("/product/delete")
    public void productDelete(@RequestBody ProductDto productDto){
        productService.productDelete(productDto);
    }
}
