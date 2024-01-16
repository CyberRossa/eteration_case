package com.eteration.simplebanking.model;



/**
 * An exception thrown when an account has insufficient balance for a specific operation.
 */
public class InsufficientBalanceException extends Exception {
    
    /**
     * Constructs a new InsufficientBalanceException with the specified detail message.
     *
     * @param message The detail message.
     */
    
    
    public InsufficientBalanceException(String message)
    {
        super(message);
    }
}
