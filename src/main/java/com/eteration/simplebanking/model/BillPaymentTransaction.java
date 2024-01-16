package com.eteration.simplebanking.model;

import javax.persistence.Entity;

/**
 * Represents a bill payment transaction.
 * 
 * <p>This class extends the Transaction class and adds additional information for bill payments.</p>
 * 
 */

@Entity
public class BillPaymentTransaction  extends Transaction{

    // Payee of the bill
    private String payee ;

    /**
     * Constructs a new bill payment transaction with the specified amount and payee.
     *
     * @param amount the amount of the payment
     * 
     * @param payee  the payee of the bill
     * 
     */

    public BillPaymentTransaction(double amount, String payee) {
        super(amount);
        this.payee = payee;
    }

    public String getPayee() {
        return payee;
    }

    public void setPayee(String payee) {
        this.payee = payee;
    }
    

}
