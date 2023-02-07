package com.accountManagement.accountmanagement.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AccountManagementFailure {
    @JsonProperty(value = "code")
    String code;

    @JsonProperty(value = "message")
    String message;

    @JsonProperty(value = "reason")
    String reason;
}
