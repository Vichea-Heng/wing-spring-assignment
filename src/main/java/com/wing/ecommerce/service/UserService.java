package com.wing.ecommerce.service;

import com.wing.ecommerce.dao.UserRepository;
import com.wing.ecommerce.dto.UserCreationDTO;
import com.wing.ecommerce.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity registerUser(UserCreationDTO dto){
        UserEntity userEntity = dto.toUserEntity();
        return userRepository.save(userEntity);
    }

    public List<UserEntity> getUsers() {
        return userRepository.findAll();
    }

    public UserEntity getUser(Integer id){
        return userRepository.findById(id).orElseThrow();
    }
}
