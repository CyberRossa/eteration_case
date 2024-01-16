package com.eteration.simplebanking.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * 
 * <p> This class provides methods to manage bank transactions, such as crediting and debiting the account
 */

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Account owners name
    public String owner;

    //account Number 
    public String accountNumber;

    //account balance 
    public double balance;

    //List of Transactions
    @OneToMany(mappedBy =  "account", cascade = CascadeType.ALL)
    public List<Transaction> transactions = new ArrayList<>(); 

    public Account(String string, String string2) {
        //TODO Auto-generated constructor stub
    }

    /**
     * Posts a transaction to the account 
     * 
     * @param transaction the transaction to be posted
     * 
     */

     public void post(Transaction transaction)
     {
        this.transactions.add(transaction);
        transaction.setAccount(this);
     }

    /**
     * Credits the account with the specified amount.
     * 
     * @param amount the amount to be credited
     */

    public void credit(double amount)
    {
        balance += amount;
    }

     /**
     * Debits the bank account with the specified amount.
     *
     * @param amount the amount to be debited
     * @return true if the operation is successful, false otherwise
     * @throws InsufficientBalanceException if the amount does not have sufficient balance
     */
    public boolean debit(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient funds");
        }
        balance -= amount;
        return true;
    }


    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }


}
