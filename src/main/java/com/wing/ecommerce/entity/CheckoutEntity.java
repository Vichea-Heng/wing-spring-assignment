package com.wing.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

@Entity
public class CheckoutEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idGen")
    @SequenceGenerator(initialValue = 1, name = "idGen", sequenceName = "entityCheckout")
    private Integer id;

    @ManyToOne(cascade = CascadeType.MERGE, optional = false)
    @JoinColumn(name = "user_id")
    @JsonIdentityReference
    private UserEntity userEntity;

    @ManyToOne(cascade = CascadeType.MERGE, optional = false)
    @JoinColumn(name = "product_id")
    @JsonIdentityReference
    private ProductEntity productEntity;
    private Integer quantity;
    private LocalDateTime createdDatetime;

    public CheckoutEntity(){}

    public CheckoutEntity(UserEntity userEntity, ProductEntity productEntity, Integer quantity, LocalDateTime createdDatetime) {
        this.userEntity = userEntity;
        this.productEntity = productEntity;
        this.quantity = quantity;
        this.createdDatetime = createdDatetime;
    }

    public Integer getId() {
        return id;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getCreatedDatetime() {
        return DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).format(createdDatetime);
    }
}
