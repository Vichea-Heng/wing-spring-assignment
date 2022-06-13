package com.wing.ecommerce.vo;

import com.wing.ecommerce.enumclass.GenderEnum;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class UserVO {
    private Integer id;
    private String fullName;
    private GenderEnum gender;
    private LocalDate dob;
    private Integer createdBy;
    private LocalDateTime createdDatetime;
    private Integer updatedBy;
    private LocalDateTime updatedDatetime;

    public UserVO(Integer id, String fullName, GenderEnum gender, LocalDate dob, Integer createdBy, LocalDateTime createdDatetime, Integer updatedBy, LocalDateTime updatedDatetime) {
        this.id = id;
        this.fullName = fullName;
        this.gender = gender;
        this.dob = dob;
        this.createdBy = createdBy;
        this.createdDatetime = createdDatetime;
        this.updatedBy = updatedBy;
        this.updatedDatetime = updatedDatetime;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        UserVO user = (UserVO) obj;

        return Objects.equals(id, user.id)
                && Objects.equals(fullName, user.fullName)
                && Objects.equals(gender, user.gender)
                && Objects.equals(dob, user.dob)
                && Objects.equals(createdBy, user.createdBy)
                && Objects.equals(createdDatetime, user.createdDatetime)
                && Objects.equals(updatedBy, user.updatedBy)
                && Objects.equals(updatedDatetime, user.updatedDatetime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, gender, dob,createdBy,createdDatetime,updatedBy,updatedDatetime);
    }

    public Integer getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public GenderEnum getGender() {
        return gender;
    }

    public LocalDate getDob() {
        return dob;
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
