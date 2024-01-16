package com.eteration.simplebanking.model;

import javax.persistence.Entity;

/**
 * Represents a deposit transaction.
 * 
 * <p>This class extends the Transaction class and provides specific functionality for deposits.</p>
 * 
 */

@Entity
public class DepositTransaction extends Transaction  {

    /**
     * constructs a new deposit transaction with the specified amount
     * 
     * @param amount the amount of the deposit
     *      
     */

     public DepositTransaction(double amount)
     {
        super(amount);
     }
}
