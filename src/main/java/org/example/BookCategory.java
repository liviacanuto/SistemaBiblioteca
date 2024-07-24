package org.example;

public abstract class BookCategory {
    private String categoryName;

    public abstract boolean isCategory(String category);

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return this.categoryName;
    }
}
