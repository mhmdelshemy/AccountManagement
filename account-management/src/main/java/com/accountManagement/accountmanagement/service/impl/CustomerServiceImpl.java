package com.accountManagement.accountmanagement.service.impl;

import com.accountManagement.accountmanagement.dto.AccountDto;
import com.accountManagement.accountmanagement.dto.AccountTransactionDto;
import com.accountManagement.accountmanagement.dto.CustomerDto;
import com.accountManagement.accountmanagement.dto.CustomerTransactionDto;
import com.accountManagement.accountmanagement.exception.CustomerNotFoundException;
import com.accountManagement.accountmanagement.model.Customer;
import com.accountManagement.accountmanagement.repo.CustomerRepo;
import com.accountManagement.accountmanagement.service.CustomerService;
import com.accountManagement.accountmanagement.service.TransactionRemoteCall;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepo customerRepo;
    private final TransactionRemoteCall transactionRemoteCall;
    private final ModelMapper modelMapper;

    public Customer getCustomerById(Long id){
        log.debug("Getting customer by id : {}",id);
        return customerRepo.findById(id).orElseThrow(CustomerNotFoundException::new);

    }
    @Override
    public Customer saveCustomer(Customer customer) {
        log.debug("Saving customer : {}",customer);
        return customerRepo.save(customer);
    }

    public CustomerTransactionDto getCustomerWithTransaction(Long customerId) {
        var customer = getCustomerById(customerId);
        log.info("Mapping customer to customerDto");
        var customerDto = modelMapper.map(customer,CustomerDto.class);
        log.debug("customerDto : {}",customerDto);
        List<AccountTransactionDto> accountTransactionDtoList = transactionRemoteCall
                                                                .getTransactionById(customerDto.getAccounts()
                                                                .stream()
                                                                .map(AccountDto::getId)
                                                                .collect(Collectors.toList()));
        log.debug("accountTransactionDtoList.size() is : {}",accountTransactionDtoList.size());

        return CustomerTransactionDto.builder()
                .customerDto(customerDto)
                .accountTransactionDtoList(accountTransactionDtoList)
                .build();

    }

}
