package com.accountManagement.accountmanagement.service;

import com.accountManagement.accountmanagement.dto.AccountRegister;
import com.accountManagement.accountmanagement.model.Account;

public interface AccountService {
    Account createAccount(AccountRegister accountRegister) throws Exception;
}
