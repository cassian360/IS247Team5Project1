package com.financetracker.model;

import java.util.Date;

/**
 * Class representing expense transactions
 * Extends the abstract Transaction class
 */
public class Expense extends Transaction {
    // Additional field specific to Expense
    private boolean isRecurring;
    
    // Static variable for count tracking (requirement 22)
    private static int totalExpenseTransactions = 0;
    
    /**
     * Constructor for Expense
     * Example of inheritance (requirement 6)
     * 
     * @param amount Expense amount
     * @param description Expense description
     * @param category Expense category
     * @param date Date of transaction
     */
    public Expense(double amount, String description, String category, Date date) {
        // Using super keyword (requirement 17)
        super(amount, description, category, date);
        this.isRecurring = false;
        totalExpenseTransactions++;  // Increment static counter
    }
    
    /**
     * Overloaded constructor with isRecurring parameter
     * Example of method overloading (requirement 12)
     * 
     * @param amount Expense amount
     * @param description Expense description
     * @param category Expense category
     * @param date Date of transaction
     * @param isRecurring Whether expense is recurring
     */
    public Expense(double amount, String description, String category, Date date, boolean isRecurring) {
        super(amount, description, category, date);
        this.isRecurring = isRecurring;
        totalExpenseTransactions++;  // Increment static counter
    }
    
    /**
     * Get total count of expense transactions
     * Static method example (requirement 22)
     * 
     * @return Count of expense transactions
     */
    public static int getTotalExpenseTransactions() {
        return totalExpenseTransactions;
    }
    
    /**
     * Check if expense is recurring
     * 
     * @return True if recurring, false otherwise
     */
    public boolean isRecurring() {
        return isRecurring;
    }
    
    /**
     * Set whether expense is recurring
     * 
     * @param recurring True if recurring, false otherwise
     */
    public void setRecurring(boolean recurring) {
        isRecurring = recurring;
    }
    
    /**
     * Get transaction type
     * Implementation of abstract method (requirements 11 & 18)
     * 
     * @return String "Expense" with recurring indicator if applicable
     */
    @Override
    public String getType() {
        return isRecurring ? "Expense (Recurring)" : "Expense";
    }
    
    /**
     * Get signed amount (negative for expense)
     * Implementation of abstract method
     * 
     * @return Negative amount
     */
    @Override
    public double getSignedAmount() {
        return -amount;  // Expense subtracts from balance
    }
    
    /**
     * Returns string representation of expense
     * Overrides toString method from Transaction class
     * Example of method overriding (requirement 11)
     * 
     * @return String representation
     */
    @Override
    public String toString() {
        String baseString = super.toString();
        if (isRecurring) {
            return baseString + " [Recurring]";
        }
        return baseString;
    }
}