package com.accountManagement.accountmanagement.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@Getter
public class AccountManagementException extends ResponseStatusException {

    final String code;
    final String reason;

    public AccountManagementException(HttpStatus httpStatus, String code, String reason) {
        super(httpStatus);
        this.code = code;
        this.reason = reason;
    }
}
