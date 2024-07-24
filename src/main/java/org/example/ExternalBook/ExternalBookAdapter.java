package org.example.ExternalBook;

import org.example.Book;
import org.example.Category;

public class ExternalBookAdapter extends Book implements BookAdapter {
    public ExternalBookAdapter(int id, String title, boolean available, String author, Category category) {
        super(id, title, available, author, category);
    }

    @Override
    public boolean temCategoria(String category) {
        return isCategory(category);
    }
}
