package com.accountManagement.accountmanagement.service;

import com.accountManagement.accountmanagement.model.Customer;
import reactor.core.publisher.Flux;

public interface CustomerService {

    Flux<Customer> getAllCustomers();
}
