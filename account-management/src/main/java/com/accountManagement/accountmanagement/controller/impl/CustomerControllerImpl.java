package com.accountManagement.accountmanagement.controller.impl;

import com.accountManagement.accountmanagement.controller.CustomerController;
import com.accountManagement.accountmanagement.model.Customer;
import com.accountManagement.accountmanagement.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/account-management/")
public class CustomerControllerImpl implements CustomerController {

    private final CustomerService customerService;

    @GetMapping("customers")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<Customer> getAllItems() {
        return customerService.getAllCustomers();
    }
}
