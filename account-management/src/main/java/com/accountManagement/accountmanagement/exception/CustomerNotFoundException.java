package com.accountManagement.accountmanagement.exception;

import org.springframework.http.HttpStatus;

public class CustomerNotFoundException extends AccountManagementException{

    public CustomerNotFoundException() {
        super(HttpStatus.NOT_FOUND, ErrorCodes.CUSTOMER_NOT_FOUND.getErrorCode(),
                ErrorCodes.CUSTOMER_NOT_FOUND.getErrorReason());
    }
}
