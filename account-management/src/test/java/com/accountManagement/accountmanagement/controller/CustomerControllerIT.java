package com.accountManagement.accountmanagement.controller;

import com.accountManagement.accountmanagement.constant.ApiConstant;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
public class CustomerControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getCustomerTransactionsIT() throws Exception {
        Long cid = 1002L;
        ResultActions response = mockMvc.perform(get("/"+ ApiConstant.ACCOUNT_MANAGEMENT_MAPPING+ApiConstant.CUSTOMER_MAPPING+"{cid}",cid));

        response.andDo(print()).
                andExpect(status().isOk())
                .andExpect(jsonPath("$.customerDto.id").value(String.valueOf(cid)));
    }

}
