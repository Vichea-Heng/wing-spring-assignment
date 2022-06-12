package com.wing.ecommerce.controller;

import com.wing.ecommerce.dao.ProductRepository;
import com.wing.ecommerce.dto.ProductCreationDTO;
import com.wing.ecommerce.dto.ProductUpdateDTO;
import com.wing.ecommerce.dto.UserCreationDTO;
import com.wing.ecommerce.entity.ProductEntity;
import com.wing.ecommerce.entity.UserEntity;
import com.wing.ecommerce.enumclass.GenderEnum;
import com.wing.ecommerce.service.ProductService;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ProductControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ProductService productService;
    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductController productController;

    @BeforeEach
    public void setup() throws Exception{
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
    }

    @Test
    public void registerProduct() throws Exception {
        ProductCreationDTO dto = new ProductCreationDTO("Product A", "P-A", 20,null);
        ProductEntity productEntity = dto.toProductEntity();

        Mockito.when(productRepository.save(productEntity)).thenReturn(productEntity);
        Mockito.when(productService.registerProduct(dto)).thenReturn(productEntity);

        Map<String, String> requestJson = new HashMap<>();
        requestJson.put("productName", "Product A");
        requestJson.put("productCode", "P-A");
        requestJson.put("quantity", "20");
        requestJson.put("createdBy", "1");
        JSONObject json = new JSONObject(requestJson);

        this.mockMvc.perform(
                        post("/product")
                                .contentType(APPLICATION_JSON)
                                .content(json.toString())
                )
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void updateProduct() throws Exception {
        ProductCreationDTO dto = new ProductCreationDTO("Product A", "P-A", 20,null);
        Mockito.when(productService.registerProduct(dto)).thenReturn(dto.toProductEntity());

        ProductEntity oldProductEntity = productService.registerProduct(dto);

        ProductUpdateDTO updateDTO = new ProductUpdateDTO("Product B", "P-B", 10,null);
        ProductEntity newProductEntity = updateDTO.toNewProductEntity(oldProductEntity);

        Mockito.when(productRepository.saveAndFlush(newProductEntity)).thenReturn(newProductEntity);
        Mockito.when(productService.updateProduct(1,updateDTO)).thenReturn(oldProductEntity);

        Map<String, String> requestJson = new HashMap<>();
        requestJson.put("productName", "Product B");
        requestJson.put("productCode", "P-B");
        requestJson.put("quantity", "10");
        requestJson.put("updatedBy", "1");
        JSONObject json = new JSONObject(requestJson);

        this.mockMvc.perform(
                        put("/product/1")
                                .contentType(APPLICATION_JSON)
                                .content(json.toString())
                )
                .andDo(print())
                .andExpect(status().isOk());
    }
}
