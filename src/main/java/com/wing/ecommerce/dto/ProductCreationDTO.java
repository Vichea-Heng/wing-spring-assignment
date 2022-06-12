package com.wing.ecommerce.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wing.ecommerce.entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Data
public class ProductCreationDTO {
    @NotEmpty
    private String productName;
    @NotEmpty
    private String productCode;
    @NotEmpty
    @Min(0)
    private Integer quantity;
    @NotEmpty
    private Integer createdBy; // store as an id, easy for getting the accurate name of that user
    @JsonIgnore
    private final LocalDateTime createdDatetime = LocalDateTime.now();
    @JsonIgnore
    private final Integer updatedBy = null; // store as an id, easy for getting the accurate name of that user
    @JsonIgnore
    private final LocalDateTime updatedDatetime = LocalDateTime.now();

    public ProductCreationDTO(){}
    public ProductCreationDTO(String productName, String productCode, Integer quantity, Integer createdBy) {
        this.productName = productName;
        this.productCode = productCode;
        this.quantity = quantity;
        this.createdBy = createdBy;
    }

    public ProductEntity toProductEntity(){
        return new ProductEntity(
            this.productName,
            this.productCode,
            this.quantity,
            this.createdBy,
            this.createdDatetime,
                null,
            this.updatedDatetime
        );
    }
}
