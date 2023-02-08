package com.accountManagement.accountmanagement.controller;

import com.accountManagement.accountmanagement.dto.CustomerTransactionDto;


public interface CustomerController {

    CustomerTransactionDto getCustomerTransactions(Long customerId) throws Exception;
}
