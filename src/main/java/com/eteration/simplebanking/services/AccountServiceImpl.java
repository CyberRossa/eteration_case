package com.eteration.simplebanking.services;

import com.eteration.simplebanking.model.Account;
import com.eteration.simplebanking.model.InsufficientBalanceException;
import com.eteration.simplebanking.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service implementation for managing bank accounts.
 * 
 * <p>Implements the methods defined in the AccountService interface.</p>
 * 
 */

@Service
public class AccountServiceImpl implements AccountService {
    
    private final AccountRepository accountRepository;

     /**
     * Constructor for AccountServiceImpl.
     * 
     * @param accountRepository The repository for managing accounts.
     * 
     */

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository)
    {
        this.accountRepository = accountRepository;
    }

     /**
     * Finds an account by account number.
     * 
     * @param accountNumber The account number to search for.
     * 
     * @return The found account or null if not found.
     * 
     */

    @Override
    public Account findAccount(String accountNumber)
    {
        return accountRepository.findByAccountNumber(accountNumber);

    }

      /**
     * Creates a new account.
     * 
     * @param owner The owner of the account.
     * 
     * @param accountNumber The account number.
     * 
     * @return The created account.
     * 
     */

    @Override
    public Account createAccount(String owner, String accountNumber)
    {
        Account account = new Account();
        return accountRepository.save(account);
    }

    /**
     * Credits the specified amount to the account.
     * 
     * @param accountNumber The account number to credit.
     * 
     * @param amount The amount to credit.
     * 
     * @return The updated account.
     * 
     */

    @Override
    public Account credit(String accountNumber, double amount)
    {
        Account account = accountRepository.findByAccountNumber(accountNumber);
        if(account != null)
        {
            account.credit(amount);
            return accountRepository.save(account);
        }
        return null;
    }

     /**
     * Debits the specified amount from the account.
     * 
     * @param accountNumber The account number to debit.
     * 
     * @param amount The amount to debit.
     * 
     * @return The updated account.
     * 
     * @throws InsufficientBalanceException If the account has insufficient balance.
     * 
     */

    @Override
    public Account debit(String accountNumber,double amount) throws InsufficientBalanceException
    {
        Account account = accountRepository.findByAccountNumber(accountNumber);
        if (account != null) {
            account.debit(amount);
            return accountRepository.save(account);
        }
        return null;
    }
}
