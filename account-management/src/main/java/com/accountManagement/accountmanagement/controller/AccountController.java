package com.accountManagement.accountmanagement.controller;

import com.accountManagement.accountmanagement.dto.AccountRegister;
import com.accountManagement.accountmanagement.model.Account;

public interface AccountController {

    Account createAccount(AccountRegister accountRegister) throws Exception;
}
