package com.accountManagement.accountmanagement.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
public class AccountTransactionDto {

    private Long id;
    private Long accountId;
    private double amount;

}
