package com.example.codeexamples.elasticsearch.controller;

import com.example.codeexamples.elasticsearch.exception.ProductNotFoundException;
import com.example.codeexamples.elasticsearch.service.ProductService;
import com.example.codeexamples.elasticsearch.model.Product;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/elasticsearch/product")
@Api(tags = "Elasticsearch example API")
@RestController
public class ProductController {

    private final ProductService productService;

    @GetMapping("/{id}")
    @ApiOperation(value = "Get product")
    public ResponseEntity<Product> getProductById(@PathVariable String id) {
        try {
            return ResponseEntity.ok(productService.findById(id));
        } catch (ProductNotFoundException e) {
            log.error("Could not find a product with id: {}", id);
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @ApiOperation(value = "Save new product")
    public ResponseEntity<Product> saveProduct(@Valid @RequestBody Product product) {
        return ResponseEntity.ok(productService.save(product));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update product")
    public ResponseEntity<?> updateProduct(@Valid @RequestBody Product product, @PathVariable String id) {
       try {
           return ResponseEntity.ok(productService.update(id, product));
       } catch (ProductNotFoundException e) {
           log.error("Could not find a product with id: {} to upgrade", id);
           return ResponseEntity.badRequest().body("Incorrect product id");
       }
    }

    @PostMapping("/{id}/unavailable")
    @ApiOperation(value = "Set product unavailable")
    public ResponseEntity<?> setProductUnavailable(@PathVariable String id) {
        try {
            productService.setProductUnavailable(id);
            return ResponseEntity.ok().build();
        } catch (ProductNotFoundException e) {
            log.error("Could not find a product with id: {} to set unavailable", id);
            return ResponseEntity.badRequest().body("Incorrect product id");
        }
    }

    @PostMapping("/{id}/available")
    @ApiOperation(value = "Set product available")
    public ResponseEntity<?> setProductAvailable(@PathVariable String id) {
        try {
            productService.setProductAvailable(id);
            return ResponseEntity.ok().build();
        } catch (ProductNotFoundException e) {
            log.error("Could not find a product with id: {} to set available", id);
            return ResponseEntity.badRequest().body("Incorrect product id");
        }
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete product")
    public ResponseEntity<?> deleteProduct(@Valid @PathVariable String id) {
        try {
            productService.delete(id);
            return ResponseEntity.ok().build();
        } catch (ProductNotFoundException e) {
            log.error("Could not find a product with id: {} to delete", id);
            return ResponseEntity.badRequest().body("Incorrect product id");
        }
    }

}
