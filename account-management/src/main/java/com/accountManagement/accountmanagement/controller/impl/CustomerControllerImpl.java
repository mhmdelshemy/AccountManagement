package com.accountManagement.accountmanagement.controller.impl;

import com.accountManagement.accountmanagement.constant.ApiConstant;
import com.accountManagement.accountmanagement.controller.CustomerController;
import com.accountManagement.accountmanagement.dto.CustomerTransactionDto;
import com.accountManagement.accountmanagement.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(ApiConstant.ACCOUNT_MANAGEMENT_MAPPING)
public class CustomerControllerImpl implements CustomerController {

    private final CustomerService customerService;

    @GetMapping(ApiConstant.CUSTOMER_MAPPING+"{cid}")
    @ResponseStatus(value = HttpStatus.OK)
    public CustomerTransactionDto getCustomerTransactions(@PathVariable("cid") Long customerId) throws Exception {
        return customerService.getCustomerWithTransaction(customerId);

    }
}
