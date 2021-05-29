package com.example.codeexamples.elasticsearch.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.codeexamples.elasticsearch.model.Product;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.testcontainers.elasticsearch.ElasticsearchContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
class ProductRepositoryTest{

    @Container
    private static final ElasticsearchContainer container = new ProductElasticsearchContainer();

    @Autowired
    private ProductRepository repository;

    @BeforeAll
    static void setUp() {
        container.start();
    }

    @AfterAll
    static void destroy() {
        container.stop();
    }

    @BeforeEach
    void cleanUp() {
        repository.deleteAll();
    }

    @Test
    void findById_whenProductExists_shouldFindProductById() {
        Product product = new Product().setId("111").setName("productName");
        repository.save(product);

        assertThat(repository.findById("111").get().getName()).isEqualTo("productName");
    }

    @Test
    void findById_whenProductNotExists_shouldNotFindProductById() {
        assertThat(repository.findById("111")).isEmpty();
    }

    @Test
    void save_shouldSaveProductSuccessfully() {
        Product product = new Product().setId("111");
        Product savedIntegration = repository.save(product);

        assertThat(savedIntegration).isEqualTo(product);
        assertThat(repository.existsById(product.getId())).isTrue();
    }

    @Test
    void delete_whenDeleteById_shouldDeleteSuccessfully() {
        Product product = new Product().setId("111");
        repository.save(product);
        repository.deleteById(product.getId());

        assertThat(repository.existsById(product.getId())).isFalse();
    }
}