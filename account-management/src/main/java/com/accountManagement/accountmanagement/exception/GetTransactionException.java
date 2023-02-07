package com.accountManagement.accountmanagement.exception;

import org.springframework.http.HttpStatus;

public class GetTransactionException extends AccountManagementException{

    public GetTransactionException() {
        super(HttpStatus.INTERNAL_SERVER_ERROR, ErrorCodes.TRANSACTIONS_ADD_FAILURE.getErrorCode(),
                ErrorCodes.TRANSACTIONS_ADD_FAILURE.getErrorReason());
    }
}
