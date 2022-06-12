package com.wing.ecommerce.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wing.ecommerce.entity.CheckoutEntity;
import com.wing.ecommerce.entity.UserEntity;
import com.wing.ecommerce.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
public class CheckoutDTO {
    @NotEmpty
    private Integer userId;
    @NotEmpty
    List<Map<String, String>> products;

    @JsonIgnore
    private final LocalDateTime createdDatetime= LocalDateTime.now();

    private UserEntity userEntity;

    public CheckoutDTO(){}

    public CheckoutDTO(Integer userId, List<Map<String, String>> products) {
        this.userId = userId;
        this.products = products;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
}
