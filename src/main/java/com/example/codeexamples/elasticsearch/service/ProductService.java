package com.example.codeexamples.elasticsearch.service;

import com.example.codeexamples.elasticsearch.exception.ProductNotFoundException;
import com.example.codeexamples.elasticsearch.model.Product;
import com.example.codeexamples.elasticsearch.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository repository;

    public Product save(Product product) {
        return repository.save(product);
    }

    public Product findById(String productId) {
        return repository.findById(productId).orElseThrow(ProductNotFoundException::new);
    }

    public Product update(String productId, Product product) {
        Product savedProduct = findById(productId);
        product.setId(savedProduct.getId());
        return repository.save(product);
    }

    public void setProductUnavailable(String productId) {
        Product product = findById(productId);
        product.setAvailable(false);
        repository.save(product);
    }

    public void setProductAvailable(String productId) {
        Product product = findById(productId);
        product.setAvailable(true);
        repository.save(product);
    }

    public void delete(String productId) {
        repository.deleteById(productId);
    }

}
