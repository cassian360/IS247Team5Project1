package com.financetracker.exception;

/**
 * Exception for insufficient funds
 */
public class InsufficientFundsException extends Exception {
    /**
     * Available amount of funds
     */
    private double available;
    
    /**
     * Requested amount of funds
     */
    private double requested;
    
    /**
     * Constructor for InsufficientFundsException
     * 
     * @param message Error message
     * @param available Available amount
     * @param requested Requested amount
     */
    public InsufficientFundsException(String message, double available, double requested) {
        super(message);
        this.available = available;
        this.requested = requested;
    }
    
    /**
     * Get available amount
     * 
     * @return Available amount
     */
    public double getAvailable() {
        return available;
    }
    
    /**
     * Get requested amount
     * 
     * @return Requested amount
     */
    public double getRequested() {
        return requested;
    }
    
    /**
     * Get shortfall amount
     * 
     * @return Shortfall (requested - available)
     */
    public double getShortfall() {
        return requested - available;
    }
}