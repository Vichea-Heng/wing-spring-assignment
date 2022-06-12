package com.wing.ecommerce.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.wing.ecommerce.entity.UserEntity;
import com.wing.ecommerce.enumclass.GenderEnum;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class UserCreationDTO {
    @NotEmpty
    private String fullName;
    @NotEmpty
    private GenderEnum gender;
    @NotEmpty
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dob;
    private Integer createdBy; // store as an id, easy for getting the accurate name of that user
    @JsonIgnore
    private final LocalDateTime createdDatetime = LocalDateTime.now();
    @JsonIgnore
    private final Integer updatedBy = null; // store as an id, easy for getting the accurate name of that user
    @JsonIgnore
    private final LocalDateTime updatedDatetime = LocalDateTime.now();

    public UserCreationDTO(){}

    public UserCreationDTO(String fullName, GenderEnum gender, LocalDate dob, Integer createdBy) {
        this.fullName = fullName;
        this.gender = gender;
        this.dob = dob;
        this.createdBy = createdBy;
    }

    public UserEntity toUserEntity(){
        return new UserEntity(
            this.fullName,
            this.gender,
            this.dob,
            this.createdBy,
            this.createdDatetime,
                null,
            this.updatedDatetime
        );
    }
}
