package com.cubeia.controller;

import com.cubeia.model.Transactions;
import com.cubeia.model.Transfer;
import com.cubeia.repository.AccountRepository;
import com.cubeia.repository.TransactionRepository;
import com.cubeia.model.Account;
import com.cubeia.model.Transaction;
import com.cubeia.exceptions.AccountNotFoundException;
import com.cubeia.exceptions.InsufficientBalanceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AccountingController {
    private static final Logger log = LoggerFactory.getLogger(AccountingController.class);

    private final TransactionRepository repository;
    private final AccountRepository accounts;

    AccountingController(AccountRepository accounts, TransactionRepository repository) {
        this.repository = repository;
        this.accounts = accounts;
    }

    /* Get balance on account where account id = {id} */
    @GetMapping("/get-balance/{id}")
    Account getBalance(@PathVariable long id) {

        return accounts.findById(id)
                .orElseThrow(() -> new AccountNotFoundException(id));
    }

    /* Return all transactions where account id = {id} */
    @GetMapping("/list-transactions/{id}")
    Transactions listTransactions(@PathVariable long id) {
        List<Transaction> transactions = new ArrayList<>();

        transactions.addAll(repository.findByInputIsOrOutputIs(id,id));

        return new Transactions(transactions);

    }


    /* Create new account in accounts repository */
    @PostMapping("/create-account")
    Account createAccount(@RequestBody Account account) {
        return accounts.save(account);
    }

    /* Transfer funds from one account (input) to another (output) */
    @PostMapping("/transfer")
    Transaction transfer(@RequestBody Transfer transfer) {

        /* Attempt to retrieve account objects from repository */
        Account input = accounts.findById(transfer.getInput()).orElseThrow(() -> new AccountNotFoundException(transfer.getInput()));
        Account output = accounts.findById(transfer.getOutput()).orElseThrow(() -> new AccountNotFoundException(transfer.getOutput()));

        /* Check balamce on input account */
        if ( transfer.getAmount() > input.getBalance() ) {
            throw new InsufficientBalanceException();
        }

        /* Update balance on both account objects */
        input.setBalance(input.getBalance() - transfer.getAmount());
        output.setBalance(output.getBalance() + transfer.getAmount());

        /* Save account objects to repository */
        accounts.save(input);
        accounts.save(output);

        /* Create new Transaction object */
        Transaction transaction = new Transaction(input.getId(), output.getId(),transfer.getAmount());

        /* Save transaction to repository, and return transaction details */
        return repository.save(transaction);
    }



}
