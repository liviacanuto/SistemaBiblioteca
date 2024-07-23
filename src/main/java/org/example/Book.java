package org.example;

import java.util.List;

public class Book extends BookCategory {
    private int id;
    private String title;
    private boolean available;
    private String author;
    Category category;

    @Override
    public boolean isCategory(String category) {
        if(category.equalsIgnoreCase(this.category.getCategoryName())) {
            return true;
        }
        List<BookCategory> categories = this.category.getCategories();
        for(BookCategory c : categories) {
            if(c.isCategory(category)) {
                return true;
            }
        }
        return false;
    }

    public Book(String title, boolean available, String author, Category category) {
        this.title = title;
        this.available = available;
        this.author = author;
        this.category = category;
    }

    public Book(int id, String title, boolean available, String author, Category category) {
        this(title, available, author, category);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isAvailable() {
        return this.available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Book{" + "\nid=" + id + ", \ntitle='" + title + '\'' + ", \nauthor='" + author + '\'' + ", \navailable=" + available +", \nCategory=" + category + "\n}";
    }
}
