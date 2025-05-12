package com.financetracker.model;

import com.financetracker.interfaces.FinancialEntity;

/**
 * Budget implementation of FinancialEntity interface
 */
public class Budget implements FinancialEntity {
    private String name;
    private String description;
    private double amount;
    
    /**
     * Constructor for Budget
     * 
     * @param name Budget name
     * @param description Budget description
     * @param amount Budget amount
     */
    public Budget(String name, String description, double amount) {
        this.name = name;
        this.description = description;
        this.amount = amount;
    }
    
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public String getDescription() {
        return description;
    }
    
    @Override
    public double getAmount() {
        return amount;
    }
    
    @Override
    public boolean affectsBalance() {
        return false; // Budget doesn't directly affect balance
    }
}