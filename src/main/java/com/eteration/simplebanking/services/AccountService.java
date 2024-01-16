package com.eteration.simplebanking.services;

import com.eteration.simplebanking.model.Account;
import com.eteration.simplebanking.model.InsufficientBalanceException;

/**
 * Service interface for managing bank accounts.
 * 
 * <p>Provides methods for finding accounts, creating accounts, and performing credit and debit operations.</p>
 * 
 */

public interface AccountService {

     /**
     * Finds an account by its account number.
     *
     * @param accountNumber the account number to search for
     * 
     * @return the found account, or null if no account with the specified account number exists
     * 
     */

    Account findAccount(String accountNumber);

    /**
     * Creates a new account with the specified owner and account number.
     *
     * @param owner         the owner of the account
     * 
     * @param accountNumber the account number for the new account
     * 
     * @return the created account
     * 
     */

    Account createAccount(String owner, String accountNumber);
    
    /**
     * Credits the specified amount to the account with the given account number.
     *
     * @param accountNumber the account number to credit
     * 
     * @param amount        the amount to credit
     * 
     * @return the updated account after the credit operation
     * 
     */
    
    Account credit(String accountNumber, double amount);
    
    /**
     * Debits the specified amount from the account with the given account number.
     *
     * @param accountNumber the account number to debit
     * 
     * @param amount        the amount to debit
     * 
     * @return the updated account after the debit operation
     * 
     * @throws InsufficientBalanceException if the account does not have sufficient balance for the debit
     * 
     */
    
    Account debit(String accountNumber, double amount) throws InsufficientBalanceException;
    


}

