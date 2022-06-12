package com.wing.ecommerce.controller;

import com.wing.ecommerce.dao.UserRepository;
import com.wing.ecommerce.dto.UserCreationDTO;
import com.wing.ecommerce.entity.UserEntity;
import com.wing.ecommerce.enumclass.GenderEnum;
import com.wing.ecommerce.service.UserService;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

public class UserControllerTest {
    private MockMvc mockMvc;

    @Mock
    private UserRepository userRepository;
    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    public void setup() throws Exception {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    public void registerUser() throws Exception {
        UserCreationDTO dto = new UserCreationDTO("Vichea", GenderEnum.Male, LocalDate.of(2000,12,12),null);
        UserEntity userEntity = dto.toUserEntity();

        Mockito.when(userRepository.save(userEntity)).thenReturn(userEntity);
        Mockito.when(userService.registerUser(dto)).thenReturn(userEntity);

        Map<String, String> requestJson = new HashMap<>();
        requestJson.put("fullName", "Vichea");
        requestJson.put("gender", String.valueOf(GenderEnum.Male));
        requestJson.put("dob", "2000-12-12");
        requestJson.put("createdBy", null);
        JSONObject json = new JSONObject(requestJson);

        this.mockMvc.perform(
                        post("/user")
                                .contentType(APPLICATION_JSON)
                                .content(json.toString())
                )
                .andDo(print())
                .andExpect(status().isOk());
    }
}
