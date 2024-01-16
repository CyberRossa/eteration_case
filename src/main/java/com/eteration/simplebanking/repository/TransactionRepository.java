package com.eteration.simplebanking.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eteration.simplebanking.model.Transaction;


/**
 * Repository interface for managing Transaction entities.
 * 
 * <p>Provides CRUD operations for the Transaction entity.</p>
 * 
 */

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long>
{
    
}
