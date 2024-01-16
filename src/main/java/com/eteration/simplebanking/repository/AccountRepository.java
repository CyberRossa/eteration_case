package com.eteration.simplebanking.repository;

import com.eteration.simplebanking.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 
 * Repository interface for managing Account entities.
 * 
 * <p>Provides CRUD operations for the Account entity.</p>
 * 
 */

@Repository
public interface AccountRepository extends JpaRepository<Account,Long>{
    
     /**
     * Finds an account by its account number.
     *
     * @param accountNumber the account number to search for
     * 
     * @return the found account, or null if no account with the specified account number exists
     * 
     */
    
    Account findByAccountNumber(String accountNumber);

    //spesific queries

}
