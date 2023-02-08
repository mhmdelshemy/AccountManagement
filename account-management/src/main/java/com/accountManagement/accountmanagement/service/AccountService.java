package com.accountManagement.accountmanagement.service;

import com.accountManagement.accountmanagement.dto.AccountDto;
import com.accountManagement.accountmanagement.dto.AccountRegister;

public interface AccountService {
    AccountDto createAccount(AccountRegister accountRegister) throws Exception;
}
