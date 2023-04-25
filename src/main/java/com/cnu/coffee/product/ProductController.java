package com.cnu.coffee.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping("/search/{id}")
    public Product searchProduct(@PathVariable Long id) {
        return productService.searchProduct(id);
    }

    @RequestMapping("/delete/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}
