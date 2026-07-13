package com.consultare.digitalbank.repository;

import com.consultare.digitalbank.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
