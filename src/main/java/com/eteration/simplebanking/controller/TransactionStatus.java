package com.eteration.simplebanking.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * Represents the status of a transaction response.
 * 
 * <p>This class provides methods to set and get the status of a transaction response.</p>
 * 
 */
public class TransactionStatus {

    private String status;

    /**
     * Constructs a new TransactionStatus with the specified status.
     *
     * @param status the status of the transaction
     * 
     */

    public TransactionStatus(String status) {
        this.status = status;
    }

    /**
     * Gets the status of the transaction.
     *
     * @return the status of the transaction
     * 
     */

    public String getStatus() {
        return status;
    }

    /**
     * Sets the status of the transaction.
     *
     * @param status the new status of the transaction
     * 
     */

    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Creates a new ResponseEntity with the current TransactionStatus and HTTP status OK.
     *
     * @return the ResponseEntity with HTTP status OK
     * 
     */
    
    public ResponseEntity<TransactionStatus> toResponseEntity() {
        return new ResponseEntity<>(this, HttpStatus.OK);
    }



    

   


}
