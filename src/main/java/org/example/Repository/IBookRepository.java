package org.example.Repository;

import org.example.Book;
import org.example.Category;

public interface IBookRepository
{
    Book addNewBook(String titulo, String autor, Category category);
    Book searchById(int id);
    boolean borrowBook(int id);
    boolean returnBook(int id);

}
