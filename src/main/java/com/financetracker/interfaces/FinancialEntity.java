package com.financetracker.interfaces;

/**
 * Interface for financial entities
 * (requirement 7 - Interface)
 */
public interface FinancialEntity {
    /**
     * Get name of the entity
     * 
     * @return Entity name
     */
    String getName();
    
    /**
     * Get description of the entity
     * 
     * @return Entity description
     */
    String getDescription();
    
    /**
     * Get amount associated with the entity
     * 
     * @return Associated amount
     */
    double getAmount();
    
    /**
     * Check if entity affects balance
     * 
     * @return True if affects balance, false otherwise
     */
    boolean affectsBalance();
}