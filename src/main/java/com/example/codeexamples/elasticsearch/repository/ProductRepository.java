package com.example.codeexamples.elasticsearch.repository;

import com.example.codeexamples.elasticsearch.model.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ProductRepository extends ElasticsearchRepository<Product, String> {
}
