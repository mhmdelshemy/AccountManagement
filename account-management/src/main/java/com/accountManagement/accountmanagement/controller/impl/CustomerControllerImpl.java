package com.accountManagement.accountmanagement.controller.impl;

import com.accountManagement.accountmanagement.controller.CustomerController;
import com.accountManagement.accountmanagement.dto.AccountRegister;
import com.accountManagement.accountmanagement.dto.CustomerTransactionDto;
import com.accountManagement.accountmanagement.model.Customer;
import com.accountManagement.accountmanagement.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/account-management/")
public class CustomerControllerImpl implements CustomerController {

    private final CustomerService customerService;

    @GetMapping("customers/{cid}")
    @ResponseStatus(value = HttpStatus.OK)
    public CustomerTransactionDto getCustomerTransactions(@PathVariable("cid") Long customerId) throws Exception {
        return customerService.getCustomerWithTransaction(customerId);

    }
}
