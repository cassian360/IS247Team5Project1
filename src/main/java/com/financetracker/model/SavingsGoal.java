package com.financetracker.model;

import com.financetracker.interfaces.FinancialEntity;

/**
 * SavingsGoal implementation of FinancialEntity interface
 */
public class SavingsGoal implements FinancialEntity {
    private String name;
    private String description;
    private double targetAmount;
    private double currentAmount;
    
    /**
     * Constructor for SavingsGoal
     * 
     * @param name Goal name
     * @param description Goal description
     * @param targetAmount Target amount to save
     */
    public SavingsGoal(String name, String description, double targetAmount) {
        this.name = name;
        this.description = description;
        this.targetAmount = targetAmount;
        this.currentAmount = 0.0;
    }
    
    /**
     * Add funds to savings goal
     * 
     * @param amount Amount to add
     */
    public void addFunds(double amount) {
        this.currentAmount += amount;
    }
    
    /**
     * Get progress percentage
     * 
     * @return Progress as percentage
     */
    public double getProgressPercentage() {
        return (currentAmount / targetAmount) * 100;
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
        return targetAmount;
    }
    
    /**
     * Get current saved amount
     * 
     * @return Current saved amount
     */
    public double getCurrentAmount() {
        return currentAmount;
    }
    
    @Override
    public boolean affectsBalance() {
        return true; // Savings affects balance
    }
}