package com.accountManagement.accountmanagement.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","accounts"})
public class CustomerDto {
    private Long id;
    private String firstName;
    private String surName;
    private double balance;
    private List<AccountDto> accounts;

}
