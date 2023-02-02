package com.accountManagement.accountmanagement.service.impl;

import com.accountManagement.accountmanagement.model.Customer;
import com.accountManagement.accountmanagement.repo.CustomerRepo;
import com.accountManagement.accountmanagement.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepo customerRepo;

    @Override
    public Flux<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }
}
