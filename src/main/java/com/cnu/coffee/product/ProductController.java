package com.cnu.coffee.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    ProductService ps;
    @Autowired
    ProductRepository pr;

    @RequestMapping("/save")
    public void save(@RequestBody ProductDto productDto) {
        ps.save(productDto);
    }

    @RequestMapping("/update")
    public void update(@RequestBody ProductDto productDto) {
        ps.update(productDto);
    }

    @RequestMapping("/search")
    public Optional<Product> search(@RequestBody ProductDto productDto){
        return pr.findById(productDto.getId());
    }

    @RequestMapping("/delete")
    public void delete(@RequestBody ProductDto productDto){
        ps.delete(productDto);
    }
}
