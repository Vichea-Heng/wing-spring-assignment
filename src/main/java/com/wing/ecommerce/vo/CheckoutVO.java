package com.wing.ecommerce.vo;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.wing.ecommerce.entity.ProductEntity;
import com.wing.ecommerce.entity.UserEntity;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;
import java.util.Objects;

public class CheckoutVO {
    private Integer id;
    private UserEntity userEntity;
    private ProductEntity productEntity;
    private Integer quantity;
    private LocalDateTime createdDatetime;

    public CheckoutVO(Integer id, UserEntity userEntity, ProductEntity productEntity, Integer quantity, LocalDateTime createdDatetime) {
        this.id = id;
        this.userEntity = userEntity;
        this.productEntity = productEntity;
        this.quantity = quantity;
        this.createdDatetime = createdDatetime;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        CheckoutVO checkout = (CheckoutVO) obj;

        return Objects.equals(id, checkout.id)
                && Objects.equals(userEntity.getId(), checkout.userEntity.getId())
                && Objects.equals(productEntity.getId(), checkout.productEntity.getId())
                && Objects.equals(quantity, checkout.quantity)
                && Objects.equals(createdDatetime, checkout.createdDatetime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userEntity.getId(), productEntity.getId(), quantity, createdDatetime);
    }
}
