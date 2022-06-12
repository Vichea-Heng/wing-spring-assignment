package com.wing.ecommerce.dao;

import com.wing.ecommerce.entity.CheckoutEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckoutRepository extends JpaRepository<CheckoutEntity, Integer> {
}
