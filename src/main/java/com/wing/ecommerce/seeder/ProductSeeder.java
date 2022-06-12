package com.wing.ecommerce.seeder;

import com.wing.ecommerce.dao.ProductRepository;
import com.wing.ecommerce.dto.ProductCreationDTO;
import com.wing.ecommerce.entity.ProductEntity;
import com.wing.ecommerce.utility.Helper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductSeeder {
    @Bean
    CommandLineRunner productSeederCommand(ProductRepository productRepository){
        return  args -> {
            for (int i = 0; i < 10; i ++ ){
                ProductEntity productEntity = (new ProductCreationDTO(
                        "Product " + i,
                        "P-" + i,
                        Helper.randomInteger(10,20),
                        1)
                ).toProductEntity();
                productRepository.save(productEntity);
            }
        };
    }
}
