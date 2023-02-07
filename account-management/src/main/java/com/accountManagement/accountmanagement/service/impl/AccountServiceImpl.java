package com.accountManagement.accountmanagement.service.impl;

import com.accountManagement.accountmanagement.dto.AccountRegister;
import com.accountManagement.accountmanagement.model.Account;
import com.accountManagement.accountmanagement.repo.AccountRepo;
import com.accountManagement.accountmanagement.service.AccountService;
import com.accountManagement.accountmanagement.service.CustomerService;
import com.accountManagement.accountmanagement.service.TransactionRemoteCall;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountServiceImpl implements AccountService {

    private final AccountRepo accountRepo;
    private final CustomerService customerService;
    private final TransactionRemoteCall transactionRemoteCall;

    @SneakyThrows
    @Transactional
    public Account createAccount(AccountRegister accountRegister) {

        log.info("Getting customer by customerId >> accountRegister.getCustomerId(): {}",accountRegister.getCustomerId());
        var customer = customerService.getCustomerById(accountRegister.getCustomerId());
        log.debug("Customer returned is : {}",customer);

        var account = new Account();
        account.setCustomer(customer);
        account.setCreated(Instant.now());

        log.info("Account to be saved is : {}",account);
        log.info("Saving account!");
        account = accountRepo.save(account);

        if(accountRegister.getCredit()>0) {
            log.debug("Add credit by >> accountRegister.getCredit(): {} ", accountRegister.getCredit());
            customer.setBalance(customer.getBalance() + accountRegister.getCredit());
            log.info("Saving customer!");
            customerService.saveCustomer(customer);

            log.info("Remote call to transaction service , saving transaction!");
            transactionRemoteCall.addTransaction(account.getId(),accountRegister.getCredit());
        }

        log.info("Account created successfully !");

        return account;

    }


}
