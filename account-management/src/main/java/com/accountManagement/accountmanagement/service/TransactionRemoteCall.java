package com.accountManagement.accountmanagement.service;

import com.accountManagement.accountmanagement.dto.AccountTransactionDto;

import java.util.List;

public interface TransactionRemoteCall {
    List<AccountTransactionDto> getTransactionById(List<Long> accountId);
    void addTransaction(Long accountId, double amount);
}
