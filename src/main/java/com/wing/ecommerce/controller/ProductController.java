package com.wing.ecommerce.controller;

import com.wing.ecommerce.dto.ProductCreationDTO;
import com.wing.ecommerce.dto.ProductUpdateDTO;
import com.wing.ecommerce.entity.ProductEntity;
import com.wing.ecommerce.service.ProductService;
import com.wing.ecommerce.utility.SpringLoggingHelper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping(value = "/product", consumes = "application/json")
    public ProductEntity registerProduct(@RequestBody ProductCreationDTO productCreationDTO){
        new SpringLoggingHelper().helperMethod();

        return productService.registerProduct(productCreationDTO);
    }

    @PutMapping(value = "/product/{id}", consumes = "application/json")
    public ProductEntity updateProduct(@PathVariable("id") Integer id, @RequestBody ProductUpdateDTO productUpdateDTO){
        new SpringLoggingHelper().helperMethod();

        ProductEntity result = productService.updateProduct(id, productUpdateDTO);
        if(result == null) ResponseEntity.notFound();
        return result;
    }
}
