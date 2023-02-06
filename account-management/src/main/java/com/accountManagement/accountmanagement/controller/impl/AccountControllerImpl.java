package com.accountManagement.accountmanagement.controller.impl;

import com.accountManagement.accountmanagement.controller.AccountController;
import com.accountManagement.accountmanagement.dto.AccountDto;
import com.accountManagement.accountmanagement.dto.AccountRegister;
import com.accountManagement.accountmanagement.model.Account;
import com.accountManagement.accountmanagement.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/account-management/")
public class AccountControllerImpl implements AccountController {

    private final AccountService accountService;

    @PostMapping("create-account")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Account createAccount(@RequestBody @Valid AccountRegister accountRegister) throws Exception {
        return accountService.createAccount(accountRegister);
    }
}
