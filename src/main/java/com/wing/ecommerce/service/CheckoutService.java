package com.wing.ecommerce.service;

import com.wing.ecommerce.dao.CheckoutRepository;
import com.wing.ecommerce.dao.ProductRepository;
import com.wing.ecommerce.dao.UserRepository;
import com.wing.ecommerce.dto.CheckoutDTO;
import com.wing.ecommerce.entity.CheckoutEntity;
import com.wing.ecommerce.entity.ProductEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CheckoutService {
    private final CheckoutRepository checkoutRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final ProductService productService;
    @Autowired
    private SessionFactory sessionFactory;

    public CheckoutService(CheckoutRepository checkoutRepository, UserRepository userRepository, ProductRepository productRepository, ProductService productService) {
        this.checkoutRepository = checkoutRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.productService = productService;
    }
    @Transactional(rollbackOn = Exception.class)
    public List<CheckoutEntity> checkoutProduct(CheckoutDTO checkoutDTO) throws Exception {
        checkoutDTO.setUserEntity(userRepository.findById(checkoutDTO.getUserId()).orElseThrow());
        List<CheckoutEntity> list = new ArrayList<>();

        for (Map<String, String> product: checkoutDTO.getProducts()) {
            ProductEntity productEntity = productRepository.findById(Integer.parseInt(product.get("productId"))).orElseThrow();
            Integer quantity = Integer.parseInt(product.get("quantity"));

            CheckoutEntity checkoutEntity = new CheckoutEntity(
                    checkoutDTO.getUserEntity(),
                    productEntity,
                    quantity,
                    checkoutDTO.getCreatedDatetime()
            );

            checkoutRepository.save(checkoutEntity);
            list.add(checkoutEntity);
            productService.reduceQuantity(productEntity, quantity);
        }

        return list;
    }
}
