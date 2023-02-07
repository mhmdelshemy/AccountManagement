package com.accountManagement.accountmanagement.exception.handler;

import com.accountManagement.accountmanagement.exception.AccountManagementException;
import com.accountManagement.accountmanagement.exception.AccountManagementFailure;
import com.accountManagement.accountmanagement.exception.ErrorCodes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler({AccountManagementException.class})
    public ResponseEntity<AccountManagementFailure> handleApiException(AccountManagementException ex)
    {
        var failure = new AccountManagementFailure();
        failure.setCode(ex.getCode());
        failure.setMessage(ex.getMessage());
        failure.setReason(ex.getReason());
        ex.printStackTrace();

        return new ResponseEntity<>(failure, ex.getStatus());
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<AccountManagementFailure> handleGlobalException(Exception ex)
    {
        var failure = new AccountManagementFailure();
        failure.setCode(ErrorCodes.GENERAL_ERROR.getErrorCode());
        failure.setMessage(ex.getMessage());
        failure.setReason(ErrorCodes.GENERAL_ERROR.getErrorReason());
        ex.printStackTrace();

        return new ResponseEntity<>(failure, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
