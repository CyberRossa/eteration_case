package com.eteration.simplebanking.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eteration.simplebanking.model.Account;
import com.eteration.simplebanking.model.DepositTransaction;
import com.eteration.simplebanking.model.InsufficientBalanceException;
import com.eteration.simplebanking.model.WithdrawalTransaction;
import com.eteration.simplebanking.services.AccountService;

/**
 * Controller class for managing bank accounts.
 * 
 * <p>Provides REST endpoints for performing account operations such as credit, debit, and get account information.</p>
 * 
 */

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController (AccountService accountservice)
    {
        this.accountService = accountservice;
    }

    /**
     * Handles HTTP POST requests for crediting an account.
     *
     * @param accountNumber the account number to credit
     * 
     * @param transaction   the deposit transaction details
     * 
     * @return the transaction status response
     * 
     */

    @PostMapping("/accounts/{accountNumber}/credit")
    public ResponseEntity<TransactionStatus> credit(@PathVariable String accountNumber, @RequestBody DepositTransaction transaction)
    {
        Account account = accountService.findAccount(accountNumber);
        if(account != null)
        {
            TransactionStatus status = new TransactionStatus(accountNumber);
            status.setStatus("OK");

            return ResponseEntity.ok(status);

        }

        else{
            return ResponseEntity.notFound().build();
        }


    }

    /**
     * Handles HTTP POST requests for debiting an account.
     *
     * @param accountNumber the account number to debit
     * 
     * @param transaction   the withdrawal transaction details
     * 
     * @return the transaction status response
     * 
     * @throws InsufficientBalanceException if the account does not have sufficient balance for the debit
     * 
     */

    @PostMapping("/accounts/{accountNumber}/debit")
     public ResponseEntity<TransactionStatus> debit(@PathVariable String accountNumber, @RequestBody WithdrawalTransaction transaction) throws InsufficientBalanceException {
        Account account = accountService.findAccount(accountNumber);

        if (account != null) 
        {
         

            TransactionStatus status = new TransactionStatus(accountNumber);
            if (account.debit(transaction.getAmount())) {
                status.setStatus("OK");
            } else {
                status.setStatus("Failed");
            }

            return ResponseEntity.ok(status);
        } 
        else 
        {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Handles HTTP GET requests for getting account information.
     *
     * @param accountNumber the account number to get information for
     * 
     * @return the account information response
     * 
     */
    @PostMapping("/accounts/{accountNumber}")
    public ResponseEntity<Account> getAccount(@PathVariable String accountNumber) {
        Account account = accountService.findAccount(accountNumber);
    
            
        if (account != null) 
           
        {
            return ResponseEntity.ok(account);
            
        } 
            
        else 
           
        {
             
            return ResponseEntity.notFound().build();
            
        }
    
    }


  
}