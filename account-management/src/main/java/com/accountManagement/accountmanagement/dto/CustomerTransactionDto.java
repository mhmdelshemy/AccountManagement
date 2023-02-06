package com.accountManagement.accountmanagement.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class CustomerTransactionDto {

    private CustomerDto customerDto;
    private List<AccountTransactionDto> accountTransactionDtoList;

}
