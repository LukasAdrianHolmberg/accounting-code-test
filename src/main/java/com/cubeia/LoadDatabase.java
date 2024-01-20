package com.cubeia;


import com.cubeia.repository.AccountRepository;
import com.cubeia.model.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(AccountRepository accountRepository) {

        return args -> {
            log.info("Created account " + accountRepository.save(new Account(10000.0)));
            log.info("Created account " + accountRepository.save(new Account(1337.33)));
        };
    }
}
