package com.accountManagement.accountmanagement.service;

import com.accountManagement.accountmanagement.dto.CustomerTransactionDto;
import com.accountManagement.accountmanagement.model.Customer;

import java.util.List;
import java.util.Optional;


public interface CustomerService {

    Customer getCustomerById(Long id) throws Exception;
    Customer saveCustomer(Customer customer);
    CustomerTransactionDto getCustomerWithTransaction(Long customerId) throws Exception;
}
