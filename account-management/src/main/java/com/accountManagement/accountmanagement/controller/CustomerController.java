package com.accountManagement.accountmanagement.controller;

import com.accountManagement.accountmanagement.model.Customer;
import reactor.core.publisher.Flux;

public interface CustomerController {

    Flux<Customer> getAllItems();
}
