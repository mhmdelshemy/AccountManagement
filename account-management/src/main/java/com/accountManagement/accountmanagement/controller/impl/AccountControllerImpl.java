package com.accountManagement.accountmanagement.controller.impl;

import com.accountManagement.accountmanagement.constant.ApiConstant;
import com.accountManagement.accountmanagement.controller.AccountController;
import com.accountManagement.accountmanagement.dto.AccountRegister;
import com.accountManagement.accountmanagement.model.Account;
import com.accountManagement.accountmanagement.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping(ApiConstant.ACCOUNT_MANAGEMENT_MAPPING)
public class AccountControllerImpl implements AccountController {

    private final AccountService accountService;

    @PostMapping(ApiConstant.CREATE_ACCOUNT_MAPPING)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Account createAccount(@RequestBody @Valid AccountRegister accountRegister) throws Exception {
        return accountService.createAccount(accountRegister);
    }
}
