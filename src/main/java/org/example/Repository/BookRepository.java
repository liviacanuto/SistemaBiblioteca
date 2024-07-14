package org.example.Repository;

import org.example.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookRepository implements IBookRepository
{
    private List<Book> books = new ArrayList<>();
    private static BookRepository singleton;
    private int id = 1;

    private BookRepository() {}

    public static BookRepository bookRepositorySingleton()
    {
        if(singleton == null) {
            singleton = new BookRepository();
        }
        return singleton;
    }

    @Override
    public Book addNewBook(String titulo, String autor)
    {
        Book book = new Book(id++, titulo, true, autor);
        books.add(book);
        return book;
    }

    @Override
    public Book searchById(int id)
    {
        Optional<Book> livro = books.stream().filter(l -> l.getId() == id).findFirst();
        return livro.orElse(null);
    }

    @Override
    public boolean borrowBook(int id)
    {
        Book book = this.searchById(id);
        if(book != null && book.isAvailable()) {
            book.setAvailable(false);
            return true;
        }
        return false;
    }

    @Override
    public boolean returnBook(int id)
    {
        Book book = this.searchById(id);
        if(book != null) {
            book.setAvailable(true);
            return true;
        }
        return false;
    }

}
