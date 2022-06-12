package com.wing.ecommerce.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wing.ecommerce.entity.ProductEntity;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Data
public class ProductUpdateDTO {
    @NotEmpty
    private String productName;
    @NotEmpty
    private String productCode;
    @NotEmpty
    private Integer quantity;
    @NotEmpty
    private Integer updatedBy; // store as an id, easy for getting the accurate name of that user
    @JsonIgnore
    private final LocalDateTime updatedDatetime = LocalDateTime.now();

    public ProductUpdateDTO(){}

    public ProductUpdateDTO(String productName, String productCode, Integer quantity, Integer updatedBy) {
        this.productName = productName;
        this.productCode = productCode;
        this.quantity = quantity;
        this.updatedBy = updatedBy;
    }

    public ProductEntity toNewProductEntity(ProductEntity oldProductEntity){
        oldProductEntity.setProductCode(productCode);
        oldProductEntity.setProductName(productName);
        oldProductEntity.setQuantity(quantity);
        oldProductEntity.setUpdatedBy(updatedBy);
        oldProductEntity.setUpdatedDatetime(updatedDatetime);

        return oldProductEntity;
    }
}
