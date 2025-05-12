package com.financetracker.model;

import com.financetracker.manager.TransactionManager;
import com.financetracker.manager.BudgetManager;

/**
 * Represents a user of the Finance Tracker application.
 * Implements encapsulation through private fields with getters/setters.
 */
public class User {
    // Static counter for user IDs
    private static int nextUserId = 1;
    
    /**
     * Unique identifier for the user
     */
    private int id;
    
    /**
     * User's name
     */
    private String name;
    
    /**
     * User's email address
     */
    private String email;
    
    /**
     * Manager for user's transactions
     */
    private TransactionManager transactionManager;
    
    /**
     * Manager for user's budget
     */
    private BudgetManager budgetManager;
    
    /**
     * Constructor for User class
     * (requirement 16)
     * 
     * @param name User's name
     * @param email User's email address
     */
    public User(String name, String email) {
        // Using this keyword (requirement 23)
        this.id = nextUserId++;
        this.name = name;
        this.email = email;
        this.transactionManager = new TransactionManager();
        this.budgetManager = new BudgetManager();
    }
    
    /**
     * Overloaded constructor with ID parameter
     * Example of method overloading (requirement 12)
     * 
     * @param id Unique identifier
     * @param name User's name
     * @param email User's email address
     */
    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.transactionManager = new TransactionManager();
        this.budgetManager = new BudgetManager();
    }
    
    /**
     * Get the user's ID
     * 
     * @return The user's unique identifier
     */
    public int getId() {
        return id;
    }
    
    /**
     * Get the user's name
     * 
     * @return The user's name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Set the user's name
     * 
     * @param name The new name for the user
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Get the user's email
     * 
     * @return The user's email address
     */
    public String getEmail() {
        return email;
    }
    
    /**
     * Set the user's email
     * 
     * @param email The new email address for the user
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     * Get the user's transaction manager
     * 
     * @return The transaction manager associated with this user
     */
    public TransactionManager getTransactionManager() {
        return transactionManager;
    }
    
    /**
     * Get the user's budget manager
     * 
     * @return The budget manager associated with this user
     */
    public BudgetManager getBudgetManager() {
        return budgetManager;
    }
    
    /**
     * Returns a string representation of the User
     * Overrides toString method from Object class
     * Example of method overriding (requirement 11)
     * 
     * @return String representation of the user
     */
    @Override
    public String toString() {
        return "User{id=" + id + ", name='" + name + "', email='" + email + "'}";
    }
}