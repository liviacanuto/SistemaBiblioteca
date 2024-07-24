package org.example.Repository;

import org.example.Book;
import org.example.Category;

import java.util.List;

public interface IBookRepository
{
    Book addNewBook(String titulo, String autor, Category category);
    Book addNewBook(Book book);
    Book searchById(int id);
    boolean borrowBook(int id);
    boolean returnBook(int id);
    List<Book> findAll();
}
