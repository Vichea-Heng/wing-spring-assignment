package com.wing.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.wing.ecommerce.enumclass.GenderEnum;

import javax.persistence.*;
import java.text.Normalizer;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;

@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idGen")
    @SequenceGenerator(initialValue = 1, name = "idGen", sequenceName = "entityUser")
    private Integer id;

    @Column(nullable = false)
    private String fullName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private GenderEnum gender;

    @Column(nullable = false)
    private LocalDate dob;

    private Integer createdBy;
    @Column(nullable = false)
    private LocalDateTime createdDatetime;

    private Integer updatedBy;
    @Column(nullable = false)
    private LocalDateTime updatedDatetime;

    @OneToMany(mappedBy = "userEntity", fetch = FetchType.EAGER)
    @JsonBackReference
    private List<CheckoutEntity> checkoutEntities;

    public UserEntity(){}
    public UserEntity(String fullName, GenderEnum gender, LocalDate dob, Integer createdBy, LocalDateTime createdDatetime, Integer updatedBy, LocalDateTime updatedDatetime) {
        this.fullName = fullName;
        this.gender = gender;
        this.dob = dob;
        this.createdBy = createdBy;
        this.createdDatetime = createdDatetime;
        this.updatedBy = updatedBy;
        this.updatedDatetime = updatedDatetime;
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

    public String getCreatedDatetime() {
        return DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).format(createdDatetime);
    }

    public Integer getUpdatedBy() {
        return updatedBy;
    }

    public String getUpdatedDatetime() {
        return DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).format(updatedDatetime);
    }
}
