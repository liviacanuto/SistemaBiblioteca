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

    public Book(int id, String title, boolean available, String author, Category category) {
        this.id = id;
        this.title = title;
        this.available = available;
        this.author = author;
        this.category = category;
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
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", title='" + title + '\'' + ", author='" + author + '\'' + ", available=" + available + '}';
    }
}
