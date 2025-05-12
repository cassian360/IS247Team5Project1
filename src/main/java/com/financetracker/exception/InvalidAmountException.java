package com.financetracker.exception;

/**
 * Exception for invalid transaction amounts
 */
public class InvalidAmountException extends Exception {
    /**
     * Constructor for InvalidAmountException
     * 
     * @param message Error message
     */
    public InvalidAmountException(String message) {
        super(message);
    }
}