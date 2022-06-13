package com.wing.ecommerce.vo;

import javax.persistence.Column;
import java.time.LocalDateTime;
import java.util.Objects;

public class ProductVO {
    private Integer id;
    private String productName;
    private String productCode;
    private Integer quantity;
    private Integer createdBy;
    private LocalDateTime createdDatetime;
    private Integer updatedBy;
    private LocalDateTime updatedDatetime;

    public ProductVO(Integer id, String productName, String productCode, Integer quantity, Integer createdBy, LocalDateTime createdDatetime, Integer updatedBy, LocalDateTime updatedDatetime) {
        this.id = id;
        this.productName = productName;
        this.productCode = productCode;
        this.quantity = quantity;
        this.createdBy = createdBy;
        this.createdDatetime = createdDatetime;
        this.updatedBy = updatedBy;
        this.updatedDatetime = updatedDatetime;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        ProductVO product = (ProductVO) obj;

        return Objects.equals(id, product.id)
                && Objects.equals(productName, product.productName)
                && Objects.equals(productCode, product.productCode)
                && Objects.equals(quantity, product.quantity)
                && Objects.equals(createdBy, product.createdBy)
                && Objects.equals(createdDatetime, product.createdDatetime)
                && Objects.equals(updatedBy, product.updatedBy)
                && Objects.equals(updatedDatetime, product.updatedDatetime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productName, productCode, quantity, createdBy,createdDatetime,updatedBy,updatedDatetime);
    }

    public Integer getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductCode() {
        return productCode;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public LocalDateTime getCreatedDatetime() {
        return createdDatetime;
    }

    public Integer getUpdatedBy() {
        return updatedBy;
    }

    public LocalDateTime getUpdatedDatetime() {
        return updatedDatetime;
    }
}
