package com.cnu.coffee.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public void saveProduct(ProductDto productdto) {
        productRepository.save(productdto.toEntity());
    }

    public void updateProduct(ProductDto productDto) {
        Product oldData = productRepository.findById(productDto.getProductId()).orElseThrow(() ->
                new EntityNotFoundException("User not found with id " + productDto.getProductId()));
        productRepository.save(productDto.updateProduct(oldData));
    }
    public Optional<Product> searchProduct(ProductDto productDto) {
        return Optional.ofNullable(productRepository.findById(productDto.getProductId()).orElseThrow(() ->
                new EntityNotFoundException("User not found with id " + productDto.getProductId())));
    }
    public void deleteProduct(ProductDto productDto) {
        productRepository.deleteById(productDto.getProductId());
    }


}
