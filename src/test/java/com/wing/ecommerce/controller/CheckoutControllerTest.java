package com.wing.ecommerce.controller;

import com.wing.ecommerce.dao.CheckoutRepository;
import com.wing.ecommerce.dto.CheckoutDTO;
import com.wing.ecommerce.dto.ProductCreationDTO;
import com.wing.ecommerce.entity.CheckoutEntity;
import com.wing.ecommerce.entity.ProductEntity;
import com.wing.ecommerce.entity.UserEntity;
import com.wing.ecommerce.enumclass.GenderEnum;
import com.wing.ecommerce.service.CheckoutService;
import com.wing.ecommerce.service.UserService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CheckoutControllerTest {
    private MockMvc mockMvc;

    @Mock
    private CheckoutRepository checkoutRepository;

    @Mock
    private CheckoutService checkoutService;

    @InjectMocks
    private CheckoutController checkoutController;

    @BeforeEach
    public void setup() throws Exception{
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(checkoutController).build();
    }

    @Test
    public void checkoutProduct() throws Exception {
        List<Map<String, String>> products = new ArrayList<>();

        Map<String, String> product1 = new HashMap<>();
        product1.put("productId", "1");
        product1.put("quantity", "1");

        Map<String, String> product2 = new HashMap<>();
        product2.put("productId", "2");
        product2.put("quantity", "2");

        products.add(product1);
        products.add(product2);

        CheckoutDTO dto = new CheckoutDTO(1, products);

        UserEntity userEntity = new UserEntity(
                "Vichea",
        GenderEnum.Male,
        LocalDate.of(2000,12,12),
        null,
        LocalDateTime.now(),
        null,
                LocalDateTime.now()
        );

        ProductEntity productEntity1 = new ProductEntity(
                "Product A",
                "P-A",
                20,
                null,
                LocalDateTime.now(),
                null,
                LocalDateTime.now()
        );

        ProductEntity productEntity2 = new ProductEntity(
                "Product B",
                "P-B",
                20,
                null,
                LocalDateTime.now(),
                null,
                LocalDateTime.now()
        );

         List<CheckoutEntity> checkoutEntities = List.of(
                 new CheckoutEntity(userEntity, productEntity1,1, LocalDateTime.now()),
                 new CheckoutEntity(userEntity, productEntity2,2, LocalDateTime.now())
         );

        Mockito.when(checkoutService.checkoutProduct(dto)).thenReturn(checkoutEntities);

        Map<String, Object> data = new HashMap<>();
        data.put("userId", "1");
        data.put("products", products);
        JSONObject json = new JSONObject(data);

        this.mockMvc.perform(
                        post("/checkout")
                                .contentType(APPLICATION_JSON)
                                .content(json.toString())
                )
                .andDo(print())
                .andExpect(status().isOk());
    }
}
