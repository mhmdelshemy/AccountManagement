package com.accountManagement.accountmanagement.service.impl;

import com.accountManagement.accountmanagement.dto.AccountDto;
import com.accountManagement.accountmanagement.dto.AccountTransactionDto;
import com.accountManagement.accountmanagement.dto.CustomerDto;
import com.accountManagement.accountmanagement.dto.CustomerTransactionDto;
import com.accountManagement.accountmanagement.model.Account;
import com.accountManagement.accountmanagement.model.Customer;
import com.accountManagement.accountmanagement.repo.CustomerRepo;
import com.accountManagement.accountmanagement.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepo customerRepo;
    private final TransactionRemoteCall transactionRemoteCall;
    private final ModelMapper modelMapper;

    public Customer getCustomerById(Long id) throws Exception {
            return customerRepo.findById(id).orElseThrow(Exception::new);

    }
    @Override
    public Customer saveCustomer(Customer customer) {

        return customerRepo.save(customer);
    }

    public CustomerTransactionDto getCustomerWithTransaction(Long customerId) throws Exception {
        var customer = getCustomerById(customerId);
        var customerDto = modelMapper.map(customer,CustomerDto.class);
        List<AccountTransactionDto> accountTransactionDtoList = transactionRemoteCall
                                                                .getTransactionById(customerDto.getAccounts()
                                                                .stream()
                                                                .map(AccountDto::getId)
                                                                .collect(Collectors.toList()));

        return CustomerTransactionDto.builder()
                .customerDto(customerDto)
                .accountTransactionDtoList(accountTransactionDtoList)
                .build();

    }

}
