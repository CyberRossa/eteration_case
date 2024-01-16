package com.eteration.simplebanking.model;

import java.util.Date;
import javax.persistence.*;

/**
 * Represents a bank transaction.
 * 
 * <p>This is an abstract class extended by various transaction types.</p>
 * 
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Transaction {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   //Date of transaction
   public Date date;

   //Amount of the transaction
   public double amount;

   //Bank account associated with the transactin
   @ManyToOne
   @JoinColumn(name = "account_id")
   public Account account;

   /**
    * Constructor a new transaction with the specified amount
    * 
    *@param amount the amount oh the transactiom
    */

    public Transaction(double amount)
    {
        this.date = new Date();
        this.amount = amount;
    }

public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}

public Date getDate() {
    return date;
}

public void setDate(Date date) {
    this.date = date;
}

public double getAmount() {
    return amount;
}

public void setAmount(double amount) {
    this.amount = amount;
}

public Account getAccount() {
    return account;
}

public void setAccount(Account account) {
    this.account = account;
}


	
}
