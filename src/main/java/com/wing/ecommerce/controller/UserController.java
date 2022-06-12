package com.wing.ecommerce.controller;

import com.wing.ecommerce.dto.UserCreationDTO;
import com.wing.ecommerce.entity.UserEntity;
import com.wing.ecommerce.service.UserService;
import com.wing.ecommerce.utility.SpringLoggingHelper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/user", consumes = "application/json")
    public ResponseEntity<UserEntity> registerUser(@RequestBody UserCreationDTO dto){
        new SpringLoggingHelper().helperMethod();

        return ResponseEntity.ok(userService.registerUser(dto));
    }
}
