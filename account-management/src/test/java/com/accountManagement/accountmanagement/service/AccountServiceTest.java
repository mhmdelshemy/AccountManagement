package com.accountManagement.accountmanagement.service;

import com.accountManagement.accountmanagement.repo.AccountRepo;
import com.accountManagement.accountmanagement.util.DataGeneratorUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;


@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
public class AccountServiceTest {

    @MockBean
    AccountRepo accountRepo;

    @MockBean
    CustomerService customerService;

    @MockBean
    TransactionRemoteCall transactionRemoteCall;

    @Autowired
    AccountService accountService;

    @Test
    public void createAccountTest() throws Exception {
        when(accountRepo.save(ArgumentMatchers.any())).thenReturn(DataGeneratorUtil.generateAccount());
        when(customerService.getCustomerById(ArgumentMatchers.anyLong())).thenReturn(DataGeneratorUtil.generateCustomer(true));
        when(customerService.saveCustomer(ArgumentMatchers.any())).thenReturn(DataGeneratorUtil.generateCustomer(true));
        doNothing().when(transactionRemoteCall).addTransaction(ArgumentMatchers.anyLong(),ArgumentMatchers.anyDouble());

        var result = accountService.createAccount(DataGeneratorUtil.generateAccountRegister(200));
        assertEquals(1L,result.getId());

    }
}
