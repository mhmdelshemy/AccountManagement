package com.accountManagement.accountmanagement.controller;

import com.accountManagement.accountmanagement.constant.ApiConstant;
import com.accountManagement.accountmanagement.dto.AccountRegister;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
public class AccountControllerIT {
    @Autowired
    private MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void createAccountIT() throws Exception {

        var accountRegister = AccountRegister.builder()
                        .credit(100)
                        .customerId(1002L)
                        .build();
        String accountRegisterObject = objectMapper.writeValueAsString(accountRegister);

        ResultActions response = mockMvc.perform(post("/"+ ApiConstant.ACCOUNT_MANAGEMENT_MAPPING+ApiConstant.CREATE_ACCOUNT_MAPPING)
                .contentType(MediaType.APPLICATION_JSON)
                .content(accountRegisterObject));

        response.andDo(print()).
                andExpect(status().isCreated())
                .andExpect(jsonPath("$.customer.id").value(String.valueOf(accountRegister.getCustomerId())));
    }

}
