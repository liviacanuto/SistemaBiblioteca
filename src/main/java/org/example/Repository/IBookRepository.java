package org.example.Repository;

import org.example.Book;

public interface IBookRepository
{
    Book addNewBook(String titulo, String autor);
    Book searchById(int id);
    boolean borrowBook(int id);
    boolean returnBook(int id);

}
