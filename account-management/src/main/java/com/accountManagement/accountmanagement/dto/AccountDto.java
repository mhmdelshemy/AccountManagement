package com.accountManagement.accountmanagement.dto;

import lombok.*;

import java.time.Instant;



@Data
public class AccountDto {

    private Long id;
    @ToString.Exclude
    private CustomerDto customer;
    private Instant created;
}
