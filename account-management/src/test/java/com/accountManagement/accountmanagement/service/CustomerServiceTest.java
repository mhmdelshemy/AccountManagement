package com.accountManagement.accountmanagement.service;

import com.accountManagement.accountmanagement.exception.CustomerNotFoundException;
import com.accountManagement.accountmanagement.repo.CustomerRepo;
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

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
public class CustomerServiceTest {

    @MockBean
    CustomerRepo customerRepo;

    @MockBean
    TransactionRemoteCall transactionRemoteCall;

    @Autowired
    CustomerService customerService;


    @Test
    public void getCustomerByIdSuccessTest() throws Exception {
        when(customerRepo.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.of(DataGeneratorUtil.generateCustomer(true)));
        var result = customerService.getCustomerById(1L);
        assertEquals(1L,result.getId());
        assertEquals("Walter",result.getFirstName());
        assertEquals(100,result.getBalance());
    }

    @Test
    public void getCustomerByIdFailureTest() throws Exception {
        when(customerRepo.findById(ArgumentMatchers.anyLong())).thenThrow(new CustomerNotFoundException());
       assertThatThrownBy(() -> customerService.getCustomerById(1L)).isInstanceOf(CustomerNotFoundException.class);
    }


    @Test
    public void saveCustomerSuccessTest() {
        when(customerRepo.save(ArgumentMatchers.any())).thenReturn(DataGeneratorUtil.generateCustomer(true));
        assertDoesNotThrow(()-> customerService.saveCustomer(DataGeneratorUtil.generateCustomer(true)));
    }

    @Test
    public void getCustomerWithTransactionSuccess() throws Exception {
        when(customerRepo.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.of(DataGeneratorUtil.generateCustomer(true)));

        when(transactionRemoteCall.getTransactionById(ArgumentMatchers.any())).thenReturn(DataGeneratorUtil.generateAccountTransactionDtoList());

        var result = customerService.getCustomerWithTransaction(1L);
        assertEquals(1L,result.getCustomerDto().getId());
        assertEquals("Walter",result.getCustomerDto().getFirstName());
        assertEquals(100,result.getCustomerDto().getBalance());
        assertEquals(2,result.getAccountTransactionDtoList().size());

    }

    @Test
    public void getCustomerWithTransactionSuccessWithEmptyAccount() throws Exception {
        when(customerRepo.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.of(DataGeneratorUtil.generateCustomer(false)));
        when(transactionRemoteCall.getTransactionById(ArgumentMatchers.any())).thenReturn(DataGeneratorUtil.generateAccountTransactionDtoList());

        var result = customerService.getCustomerWithTransaction(1L);
        assertEquals(1L,result.getCustomerDto().getId());
        assertEquals("Walter",result.getCustomerDto().getFirstName());
        assertEquals(100,result.getCustomerDto().getBalance());
        assertEquals(0,result.getAccountTransactionDtoList().size());
    }


}
