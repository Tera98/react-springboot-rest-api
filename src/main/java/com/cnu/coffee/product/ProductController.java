package com.cnu.coffee.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping("/save")
    public void saveProduct(@RequestBody ProductDto productDto) {
        productService.saveProduct(productDto);
    }

    @RequestMapping("/update")
    public void updateProduct(@RequestBody ProductDto productDto) {
        productService.updateProduct(productDto);
    }

    @RequestMapping("/search")
    public Optional<Product> searchProduct(@RequestBody ProductDto productDto) {
        return productService.searchProduct(productDto);
    }

    @RequestMapping("/delete")
    public void deleteProduct(@RequestBody ProductDto productDto) {
        productService.deleteProduct(productDto);
    }
}
