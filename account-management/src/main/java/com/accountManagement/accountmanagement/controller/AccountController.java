package com.accountManagement.accountmanagement.controller;

import com.accountManagement.accountmanagement.dto.AccountDto;
import com.accountManagement.accountmanagement.dto.AccountRegister;

public interface AccountController {

    AccountDto createAccount(AccountRegister accountRegister) throws Exception;
}
