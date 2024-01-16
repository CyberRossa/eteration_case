package com.eteration.simplebanking.model;

import javax.persistence.Entity;

/**
 * Represents a withdrawal transaction.
 * 
 * <p>Extends the Transaction class and provides a constructor for creating a new withdrawal transaction with the specified amount.</p0
 * >
 */

 @Entity
public class WithdrawalTransaction extends Transaction {


      /**
     * Constructs a new withdrawal transaction with the specified amount.
     *
     * @param amount The amount of the withdrawal.
     */

     public WithdrawalTransaction(double amount) {
        super(amount);
    }

}


