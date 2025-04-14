package com.example.financetracker; // Main package

/**
 * Represents a category for transactions or budgets.
 * Uses equals/hashCode for proper comparison, especially in collections.
 */
public class Category {
    private String name;

    public Category(String name) {
        if (name == null || name.trim().isEmpty()) {
            // Using IllegalArgumentException for invalid constructor args is common
            throw new IllegalArgumentException("Category name cannot be empty.");
        }
        this.name = name.trim();
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name; // Simple representation often useful
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        // Case-insensitive comparison is often practical for categories
        return name.equalsIgnoreCase(category.name);
    }

    @Override
    public int hashCode() {
        return name.toLowerCase().hashCode(); // Consistent with equalsIgnoreCase
    }
}
