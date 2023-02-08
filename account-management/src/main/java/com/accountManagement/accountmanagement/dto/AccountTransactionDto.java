package com.accountManagement.accountmanagement.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccountTransactionDto {

    private Long id;
    private Long accountId;
    private double amount;

}
