package com.cnu.coffee.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

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

    public Product searchProduct(Long id) {
        return productRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("User not found with id " + id));
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
