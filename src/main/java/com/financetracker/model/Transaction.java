package com.financetracker.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Abstract class representing a financial transaction
 * Serves as a base class for Income and Expense
 * (requirement 8 - Abstract Class)
 */
public abstract class Transaction {
    // Static counter for transaction IDs
    private static int nextId = 1;
    
    protected int id;
    protected double amount;
    protected String description;
    protected String category;
    protected Date date;
    
    /**
     * Constructor for Transaction
     * 
     * @param amount Transaction amount
     * @param description Transaction description
     * @param category Transaction category
     * @param date Date of transaction
     */
    public Transaction(double amount, String description, String category, Date date) {
        this.id = nextId++;  // Assign the next available ID and increment
        this.amount = amount;
        this.description = description;
        this.category = category;
        this.date = date;
    }
    
    // Getter methods
    
    public int getId() {
        return id;
    }
    
    public double getAmount() {
        return amount;
    }
    
    public String getDescription() {
        return description;
    }
    
    public String getCategory() {
        return category;
    }
    
    public Date getDate() {
        return date;
    }
    
    /**
     * Abstract method to get transaction type
     * Must be implemented by subclasses
     * Part of abstraction (requirement 18)
     * 
     * @return String representing the transaction type
     */
    public abstract String getType();
    
    /**
     * Abstract method to determine if transaction affects balance positively or negatively
     * Must be implemented by subclasses
     * 
     * @return double value to affect balance (positive or negative)
     */
    public abstract double getSignedAmount();
    
    /**
     * Format date as string
     * 
     * @return Formatted date string
     */
    public String getFormattedDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }
    
    /**
     * Returns string representation of transaction
     * 
     * @return String representation
     */
    @Override
    public String toString() {
        return String.format("[%s] %s: $%.2f - %s (%s)",
                getFormattedDate(),
                getType(),
                amount,
                description,
                category);
    }
}