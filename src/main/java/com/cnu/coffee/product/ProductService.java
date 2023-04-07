package com.cnu.coffee.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository pr;

    public void save(ProductDto productdto) {
        Product product = productdto.toEntity(productdto);
        pr.save(product);
    }

    public void update(ProductDto productDto) {
        Product product = pr.findById(productDto.getId()).orElseThrow(() ->
                new EntityNotFoundException("User not found with id " + productDto.getId()));
        pr.save(product.updateProduct(product,productDto));
    }

    public void delete(ProductDto productDto) {
        pr.deleteById(productDto.getId());
    }
}
