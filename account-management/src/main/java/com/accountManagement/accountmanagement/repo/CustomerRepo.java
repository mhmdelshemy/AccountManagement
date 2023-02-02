package com.accountManagement.accountmanagement.repo;

import com.accountManagement.accountmanagement.model.Customer;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;

public interface CustomerRepo extends ReactiveSortingRepository<Customer,Long> {
}
