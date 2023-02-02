package com.accountManagement.accountmanagement.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;
import java.util.Set;

@Data
@NoArgsConstructor
@Table("CUSTOMER")
public class Customer {

    @Id
    @Column("CUSTOMER_ID")
    private Long id;


    @Column("FIRSTNAME")
    private String firstName;

    @Column("SURNAME")
    private String sureName;

    @Column("BALANCE")
    private double balance;

    @Column("CREATED")
    private Instant created;

    @Column("UPDATED")
    private Instant updated;

}
