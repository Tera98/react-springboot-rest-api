package com.cnu.coffee.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public void productSave(ProductDto productdto) {
        Product product = productdto.toEntity(productdto);
        productRepository.save(product);
    }

    public void productUpdate(ProductDto productDto) {
        Product product = productRepository.findById(productDto.getProductId()).orElseThrow(() ->
                new EntityNotFoundException("User not found with id " + productDto.getProductId()));
        productRepository.save(product.updateProduct(product,productDto));
    }
    public Optional<Product> productSearch(ProductDto productDto) {
        return Optional.ofNullable(productRepository.findById(productDto.getProductId()).orElseThrow(() ->
                new EntityNotFoundException("User not found with id " + productDto.getProductId())));
    }
    public void productDelete(ProductDto productDto) {
        productRepository.deleteById(productDto.getProductId());
    }


}
