package com.accountManagement.accountmanagement.dto;

import lombok.*;

import java.time.Instant;



@Data
public class AccountDto {

    private Long id;
    private CustomerDto customer;
    private Instant created;
}
