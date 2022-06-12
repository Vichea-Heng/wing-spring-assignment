package com.wing.ecommerce.controller;

import com.wing.ecommerce.dto.CheckoutDTO;
import com.wing.ecommerce.entity.CheckoutEntity;
import com.wing.ecommerce.entity.ProductEntity;
import com.wing.ecommerce.service.CheckoutService;
import com.wing.ecommerce.utility.SpringLoggingHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CheckoutController {
    private final CheckoutService checkoutService;

    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @PostMapping(value = "/checkout", consumes = "application/json")
    public List<CheckoutEntity> checkoutProduct(@RequestBody CheckoutDTO checkoutDTO) throws Exception {
        new SpringLoggingHelper().helperMethod();

        return checkoutService.checkoutProduct(checkoutDTO);
    }
}
