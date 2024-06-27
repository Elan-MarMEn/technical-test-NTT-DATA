package com.ntt.dev.test.bff_inventory.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.ntt.dev.test.bff_inventory.domain.model.Product;
import com.ntt.dev.test.bff_inventory.infrastructure.client.usecases.ProductClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import retrofit2.Response;
import retrofit2.mock.Calls;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerTest {
    @Autowired MockMvc mockMvc;
    @Autowired WebApplicationContext webApplicationContext;
    @MockBean ProductClient productClient;

    private final String URL="/v1/products/";

    private final String ERROR_CLIENT="Not client available";

    private Product genericProduct;


    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        genericProduct =
                Product.builder()
                        .id("test")
                        .expirationDate(Date.from(Instant.now()))
                        .build();
    }

    @Test
    void productById_200ok() throws Exception {

        var response = Calls.response(
                Response.success(200,genericProduct));

        Mockito.when(productClient.findProductById(anyString()))
                .thenReturn(response);
        mockMvc.perform(
                get(URL+"1")
        ).andExpect(status().isOk());
    }

    @Test
    void productById_400error() throws Exception {
        Mockito.when(productClient.findProductByCategory(anyString()))
                .thenThrow(new RuntimeException(ERROR_CLIENT));
        mockMvc.perform(
                get(URL+"1")
        ).andExpect(status().isNotFound());
    }

    @Test
    void productByCategory_200ok() throws Exception {

        var response = Calls.response(
                Response.success(
                        200, List.of(genericProduct)));

        Mockito.when(productClient.findProductByCategory(anyString()))
                .thenReturn(response);
        mockMvc.perform(
                get(URL+"categories/xxx")
        ).andExpect(status().isOk());
    }

    @Test
    void productByCategory_400error() throws Exception {
        Mockito.when(productClient.findProductByCategory(anyString()))
                .thenThrow(new RuntimeException(ERROR_CLIENT));
        mockMvc.perform(
                get(URL+"categories/xxx")
        ).andExpect(status().isNotFound());
    }

//    @Test
//    void productCreation_200ok() throws Exception {
//
//        var response = Calls.response(null);
//
//        Mockito.when(productClient.createProduct(any()))
//                .thenReturn(response);
//        mockMvc.perform(
//                post(URL)
//        ).andExpect(status().isCreated());
//    }

//    @Test
//    void productCreation_400error() throws Exception {
//        Mockito.doThrow(new RuntimeException(ERROR_CLIENT))
//                .when(productClient.createProduct(any()));
//        mockMvc.perform(
//                post(URL)
//        ).andExpect(status().isBadRequest());
//    }

//    @Test
//    void productModify_200ok() throws Exception {
//
//        var response = Calls.response(
//                Response.success(
//                        200, genericProduct));
//
//        Mockito.when(productClient.modifyProduct(any()))
//                .thenReturn(response);
//        mockMvc.perform(
//                put(URL)
//        ).andExpect(status().isOk());
//    }

    @Test
    void productModify_400error() throws Exception {
        Mockito.when(productClient.modifyProduct(any()))
                .thenThrow(new RuntimeException(ERROR_CLIENT));
        mockMvc.perform(
                put(URL)
        ).andExpect(status().isBadRequest());
    }

//    @Test
//    void productDelete_200ok() throws Exception {
//
//        var response = Calls.response(
//                Response.success(
//                        200, genericProduct));
//
//        Mockito.when(productClient.deleteProduct(any()))
//                .thenReturn(response);
//        mockMvc.perform(
//                delete(URL)
//        ).andExpect(status().isOk());
//    }

    @Test
    void productDelete_400error() throws Exception {
        Mockito.when(productClient.deleteProduct(any()))
                .thenThrow(new RuntimeException(ERROR_CLIENT));
        mockMvc.perform(
                delete(URL)
        ).andExpect(status().isBadRequest());
    }


}
