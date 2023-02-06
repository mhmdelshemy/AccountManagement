package com.accountManagement.accountmanagement.controller;

import com.accountManagement.accountmanagement.dto.AccountRegister;
import com.accountManagement.accountmanagement.dto.CustomerTransactionDto;
import com.accountManagement.accountmanagement.model.Customer;

import java.util.List;


public interface CustomerController {

    CustomerTransactionDto getCustomerTransactions(Long customerId) throws Exception;
}
