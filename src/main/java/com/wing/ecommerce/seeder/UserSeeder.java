package com.wing.ecommerce.seeder;

import com.wing.ecommerce.dao.UserRepository;
import com.wing.ecommerce.dto.UserCreationDTO;
import com.wing.ecommerce.entity.UserEntity;
import com.wing.ecommerce.enumclass.GenderEnum;
import com.wing.ecommerce.utility.Helper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class UserSeeder {
    @Bean
    CommandLineRunner userSeederCommand(UserRepository userRepository){
        return args -> {
            for (int i = 0; i < 10; i ++ ){
                UserEntity userEntity = (new UserCreationDTO(
                        "Vichea" + i,
                        (i % 2 == 0 ? GenderEnum.Female: GenderEnum.Male),
                        LocalDate.of(
                                Helper.randomInteger(1990,2000),
                                Helper.randomInteger(1,12),
                                Helper.randomInteger(1,28)),
                        null)
                ).toUserEntity();

                userRepository.save(userEntity);
            }
        };
    }
}
