package org.example;

import java.util.ArrayList;
import java.util.List;

public class Category extends BookCategory {
    private List<BookCategory> categories = new ArrayList<>();

    public void addCategory(BookCategory category) {
        categories.add(category);
    }

    public Category(String name) {
        this.setCategoryName(name);
    }

    public List<BookCategory> getCategories() {
        return this.categories;
    }

    public void setCategories(List<BookCategory> categories) {
        this.categories = categories;
    }

    @Override
    public boolean isCategory(String category) {
        if(category.equalsIgnoreCase(this.getCategoryName())) {
            return true;
        }
        for(BookCategory c : categories) {
            if(c.isCategory(category)) {
                return true;
            }
        }
        return false;
    }
}
