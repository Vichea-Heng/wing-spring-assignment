package com.wing.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;

@Entity
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idGen")
    @SequenceGenerator(initialValue = 1, name = "idGen", sequenceName = "entityProduct")
    private Integer id;

    @Column(nullable = false)
    private String productName;
    @Column(nullable = false, unique = true)
    private String productCode;
    @Column(nullable = false)
    private Integer quantity;
    @Column(nullable = false)
    private Integer createdBy;
    @Column(nullable = false)
    private LocalDateTime createdDatetime;

    private Integer updatedBy;
    @Column(nullable = false)
    private LocalDateTime updatedDatetime;

    @OneToMany(mappedBy = "productEntity", fetch = FetchType.EAGER)
    @JsonBackReference
    private List<CheckoutEntity> checkoutEntities;

    public ProductEntity() {}

    public ProductEntity(String productName, String productCode, Integer quantity, Integer createdBy, LocalDateTime createdDatetime, Integer updatedBy, LocalDateTime updatedDatetime) {
        this.productName = productName;
        this.productCode = productCode;
        this.quantity = quantity;
        this.createdBy = createdBy;
        this.createdDatetime = createdDatetime;
        this.updatedBy = updatedBy;
        this.updatedDatetime = updatedDatetime;
    }

    public Integer getId() {return id;}

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

    public String getCreatedDatetime() {
        return DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).format(createdDatetime);
    }

    public Integer getUpdatedBy() {
        return updatedBy;
    }

    public String getUpdatedDatetime() {
        return DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).format(updatedDatetime);
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
    }

    public void setUpdatedDatetime(LocalDateTime updatedDatetime) {
        this.updatedDatetime = updatedDatetime;
    }
}
