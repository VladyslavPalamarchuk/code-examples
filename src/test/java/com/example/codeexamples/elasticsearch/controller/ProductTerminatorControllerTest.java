package com.example.codeexamples.elasticsearch.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.codeexamples.elasticsearch.dto.Information;
import com.example.codeexamples.elasticsearch.exception.ProductNotFoundException;
import com.example.codeexamples.elasticsearch.model.Product;
import com.example.codeexamples.elasticsearch.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(ProductController.class)
class ProductTerminatorControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper mapper;
    @MockBean
    private ProductService service;

    private final static String PRODUCT_ID = "123";

    @Test
    void getProductById_shouldReturnProductFromElasticsearch() throws Exception {
        Product product = new Product()
                .setId(PRODUCT_ID)
                .setName("product name")
                .setAvailable(true)
                .setInformation(new Information()
                        .setDescription("desc")
                        .setInstruction("instruction")
                        .setMaterials("material")
                        .setPackaging("package")
                );

        when(service.findById(PRODUCT_ID)).thenReturn(product);

        mockMvc.perform(get("/elasticsearch/product/{id}", PRODUCT_ID))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                        {
                             "id": "123",
                             "name": "product name",
                             "information": {
                               "description": "desc",
                               "instruction": "instruction",
                               "materials": "material",
                               "packaging": "package"
                             },
                             "available": true
                           }
                        ]"""));

        verify(service, times(1)).findById(PRODUCT_ID);
    }

    @Test
    void getProductById_whenProductNotFound_thenShouldReturnNotFoundStatus() throws Exception {
        when(service.findById(PRODUCT_ID)).thenThrow(new ProductNotFoundException());

        mockMvc.perform(get("/elasticsearch/product/{id}", PRODUCT_ID))
                .andExpect(status().isNotFound());

        verify(service, times(1)).findById(PRODUCT_ID);
    }

    @Test
    void saveProduct_shouldSuccessfullySaveNewProduct() throws Exception {
        Product product = new Product()
                .setName("product name")
                .setAvailable(true)
                .setInformation(new Information()
                        .setDescription("desc")
                        .setInstruction("instruction")
                        .setMaterials("material")
                        .setPackaging("package")
                );

        when(service.save(any())).thenReturn(product.setId(PRODUCT_ID));

        mockMvc.perform(post("/elasticsearch/product")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(product)))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                        {
                             "id": "123",
                             "name": "product name",
                             "information": {
                               "description": "desc",
                               "instruction": "instruction",
                               "materials": "material",
                               "packaging": "package"
                             },
                             "available": true
                           }
                        ]"""));

        verify(service, times(1)).save(any());
    }

    @Test
    void update_shouldSuccessfullyUpdateExistProduct() throws Exception {
        Product product = new Product()
                .setId(PRODUCT_ID)
                .setName("product name")
                .setAvailable(false)
                .setInformation(new Information()
                        .setDescription("desc")
                        .setInstruction("instruction")
                        .setMaterials("material")
                        .setPackaging("package")
                );

        when(service.update(any(), any())).thenReturn(product);

        mockMvc.perform(put("/elasticsearch/product/{id}", PRODUCT_ID)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(product)))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                        {
                             "id": "123",
                             "name": "product name",
                             "information": {
                               "description": "desc",
                               "instruction": "instruction",
                               "materials": "material",
                               "packaging": "package"
                             },
                             "available": false
                           }
                        ]"""));

        verify(service, times(1)).update(any(), any());
    }

    @Test
    void update_whenProductNotFound_thenShouldReturnBadRequestStatus() throws Exception {
        when(service.update(any(), any())).thenThrow(new ProductNotFoundException());

        mockMvc.perform(put("/elasticsearch/product/{id}", PRODUCT_ID)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(new Product())))
                .andExpect(status().isBadRequest());
    }

    @Test
    void setProductUnavailable_shouldSuccessfullyChangeProductStatus() throws Exception {
        mockMvc.perform(post("/elasticsearch/product/{id}/unavailable", PRODUCT_ID))
                .andExpect(status().isOk());

        verify(service, times(1)).setProductUnavailable(PRODUCT_ID);
    }

    @Test
    void setProductUnavailable_whenProductNotFound_thenShouldReturnBadRequestStatus() throws Exception {
        doThrow(new ProductNotFoundException()).when(service).setProductUnavailable(PRODUCT_ID);

        mockMvc.perform(post("/elasticsearch/product/{id}/unavailable", PRODUCT_ID))
                .andExpect(status().isBadRequest());
    }

    @Test
    void setProductAvailable_shouldSuccessfullyChangeProductStatus() throws Exception {
        mockMvc.perform(post("/elasticsearch/product/{id}/available", PRODUCT_ID))
                .andExpect(status().isOk());

        verify(service, times(1)).setProductAvailable(PRODUCT_ID);
    }

    @Test
    void setProductAvailable_whenProductNotFound_thenShouldReturnBadRequestStatus() throws Exception {
        doThrow(new ProductNotFoundException()).when(service).setProductAvailable(PRODUCT_ID);

        mockMvc.perform(post("/elasticsearch/product/{id}/available", PRODUCT_ID))
                .andExpect(status().isBadRequest());
    }

}