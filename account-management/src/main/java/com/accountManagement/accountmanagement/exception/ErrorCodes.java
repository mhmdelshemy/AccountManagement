package com.accountManagement.accountmanagement.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCodes {

    CUSTOMER_NOT_FOUND("EC1001", "Failed to get customer from DB "),
    TRANSACTIONS_ADD_FAILURE("EC1002", "Failed to add transaction, remote service failed "),
    TRANSACTIONS_GET_FAILURE("EC1003", "Failed to get transaction, remote service failed "),
    GENERAL_ERROR("EC5xx", "Unexpected error occurred , check stack trace");


    private final String errorCode;
    private final String errorReason;
}
