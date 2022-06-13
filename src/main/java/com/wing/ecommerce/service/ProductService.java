package com.wing.ecommerce.service;

import com.wing.ecommerce.dao.ProductRepository;
import com.wing.ecommerce.dto.ProductCreationDTO;
import com.wing.ecommerce.dto.ProductUpdateDTO;
import com.wing.ecommerce.entity.ProductEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductEntity registerProduct(ProductCreationDTO dto){
        ProductEntity productEntity = dto.toProductEntity();
        return productRepository.save(productEntity);
    }

    public ProductEntity updateProduct(Integer id, ProductUpdateDTO dto){
        ProductEntity oldProductEntity = productRepository.findById(id).orElseThrow();

        ProductEntity newProductEntity = dto.toNewProductEntity(oldProductEntity);

        return productRepository.saveAndFlush(newProductEntity);
    }

    public void reduceQuantity(ProductEntity productEntity, Integer Quantity) throws Exception {
        if(productEntity.getQuantity() < Quantity){
            throw new Exception("Not enough items in stock.");
        }

        Integer newQuantity = productEntity.getQuantity() - Quantity;

        productEntity.setQuantity(newQuantity);

        productRepository.save(productEntity);
    }
}
