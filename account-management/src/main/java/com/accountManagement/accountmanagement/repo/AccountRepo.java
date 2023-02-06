package com.accountManagement.accountmanagement.repo;

import com.accountManagement.accountmanagement.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepo extends JpaRepository<Account,Long> {
}
