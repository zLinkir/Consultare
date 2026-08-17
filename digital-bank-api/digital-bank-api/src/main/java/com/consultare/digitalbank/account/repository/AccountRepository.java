package com.consultare.digitalbank.account.repository;

import com.consultare.digitalbank.account.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
