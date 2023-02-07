package com.accountManagement.accountmanagement.exception;

import org.springframework.http.HttpStatus;

public class AddTransactionException extends AccountManagementException{

    public AddTransactionException() {
        super(HttpStatus.INTERNAL_SERVER_ERROR, ErrorCodes.TRANSACTIONS_ADD_FAILURE.getErrorCode(),
                ErrorCodes.TRANSACTIONS_ADD_FAILURE.getErrorReason());
    }
}
