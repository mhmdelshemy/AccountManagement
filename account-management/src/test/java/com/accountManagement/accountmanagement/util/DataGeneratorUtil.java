package com.accountManagement.accountmanagement.util;

import com.accountManagement.accountmanagement.dto.AccountRegister;
import com.accountManagement.accountmanagement.dto.AccountTransactionDto;
import com.accountManagement.accountmanagement.model.Account;
import com.accountManagement.accountmanagement.model.Customer;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class DataGeneratorUtil {

    public static Customer generateCustomer(boolean hasAccount){
        var customer = new Customer();
        customer.setId(1L);
        customer.setBalance(100);
        customer.setFirstName("Walter");
        customer.setSurName("White");
        customer.setAccounts(new ArrayList<>());
        if (hasAccount)
            customer.setAccounts(generateListOfAccount());
        return customer;
    }

    public static List<Account> generateListOfAccount(){
        List<Account> accounts = new ArrayList<>();
        var account1 = new Account();
        account1.setId(1L);

        var account2 = new Account();
        account2.setId(2L);

        accounts.add(account1);
        accounts.add(account2);
        return accounts;
    }

    public static AccountTransactionDto generateAccountTransactionDto(Long accountId,double amount){
        var accountTransactionDto = new AccountTransactionDto();
        accountTransactionDto.setAccountId(accountId);
        accountTransactionDto.setAmount(amount);
        return accountTransactionDto;
    }

    public static List<AccountTransactionDto> generateAccountTransactionDtoList(){
        return new ArrayList<>(List
                .of(
                        generateAccountTransactionDto(1L,100),
                        generateAccountTransactionDto(2L,200)
                ));
    }

    public static Account generateAccount(){
        var account = new Account();
        account.setId(1L);
        account.setCreated(Instant.now());
        return account;
    }

    public static AccountRegister generateAccountRegister(double credit){

        return AccountRegister.builder().credit(credit).customerId(1L).build();
    }
}
