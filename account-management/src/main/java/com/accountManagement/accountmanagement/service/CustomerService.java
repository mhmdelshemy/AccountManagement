package com.accountManagement.accountmanagement.service;

import com.accountManagement.accountmanagement.dto.CustomerTransactionDto;
import com.accountManagement.accountmanagement.model.Customer;


public interface CustomerService {
    Customer getCustomerById(Long id) throws Exception;
    Customer saveCustomer(Customer customer);
    CustomerTransactionDto getCustomerWithTransaction(Long customerId) throws Exception;
}
