package com.financetracker.model;

import java.util.Date;

/**
 * Class representing income transactions
 * Extends the abstract Transaction class
 */
public class Income extends Transaction {
    // Static variable for count tracking (requirement 22)
    private static int totalIncomeTransactions = 0;
    
    /**
     * Constructor for Income
     * Example of inheritance (requirement 6)
     * 
     * @param amount Income amount
     * @param description Income description
     * @param category Income category
     * @param date Date of transaction
     */
    public Income(double amount, String description, String category, Date date) {
        // Using super keyword (requirement 17)
        super(amount, description, category, date);
        totalIncomeTransactions++;  // Increment static counter
    }
    
    /**
     * Get total count of income transactions
     * Static method example (requirement 22)
     * 
     * @return Count of income transactions
     */
    public static int getTotalIncomeTransactions() {
        return totalIncomeTransactions;
    }
    
    /**
     * Get transaction type
     * Implementation of abstract method (requirements 11 and 18)
     * 
     * @return String "Income"
     */
    @Override
    public String getType() {
        return "Income";
    }
    
    /**
     * Get signed amount (positive for income)
     * Implementation of abstract method
     * 
     * @return Positive amount
     */
    @Override
    public double getSignedAmount() {
        return amount;  // Income adds to balance
    }
}