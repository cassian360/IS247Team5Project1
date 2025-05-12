package com.financetracker.exception;

/**
 * Exception for invalid category
 */
public class InvalidCategoryException extends Exception {
    /**
     * Constructor for InvalidCategoryException
     * 
     * @param message Error message
     */
    public InvalidCategoryException(String message) {
        super(message);
    }
}