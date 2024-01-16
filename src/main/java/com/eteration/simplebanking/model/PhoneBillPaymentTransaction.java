package com.eteration.simplebanking.model;

import javax.persistence.Entity;

/**
 * Represents a phone bill payment transaction.
 * 
 * <p>This class extends the BillPaymentTransaction class and adds additional information for phone bill payments.</p>
 * 
 */

@Entity
public class PhoneBillPaymentTransaction extends BillPaymentTransaction{

    // Phone number associated with the payment
    private String phoneNumber;

    /**
     * Constructs a new phone bill payment transaction with the specified amount, payee, and phone number.
     *
     * @param payee        the payee of the bill
     * 
     * @param phoneNumber  the phone number associated with the payment
     * 
     * @param amount       the amount of the payment
     * 
     */
  
    public PhoneBillPaymentTransaction(String payee, String phoneNumber, double amount) {
        super(amount, payee);
        this.phoneNumber = phoneNumber;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

  
}
