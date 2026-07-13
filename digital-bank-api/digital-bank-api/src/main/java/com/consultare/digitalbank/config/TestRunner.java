package com.consultare.digitalbank.config;

import com.consultare.digitalbank.repository.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestRunner implements CommandLineRunner {

    private final AccountRepository accountRepository;

    public TestRunner(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Test runner implementation
    }
}
