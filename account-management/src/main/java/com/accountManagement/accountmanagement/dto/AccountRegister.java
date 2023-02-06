package com.accountManagement.accountmanagement.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Data
public class AccountRegister {

    @NotNull(message = "No customer data provided")
    private Long customerId;

    @NotNull(message = "No credit data provided")
    @PositiveOrZero
    private double credit;
}
