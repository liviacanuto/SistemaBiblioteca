package org.example.Repository;

import org.example.Book;
import org.example.Category;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookRepository implements IBookRepository
{
    private List<Book> books = new ArrayList<>();
    private static BookRepository singleton;
    private int id = 1000;

    private BookRepository() {}

    public static BookRepository bookRepositorySingleton()
    {
        if(singleton == null) {
            singleton = new BookRepository();
        }
        return singleton;
    }

    @Override
    public Book addNewBook(String titulo, String autor, Category category)
    {
        Book book = new Book(id++, titulo, true, autor, category);
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

    @Override
    public Book addNewBook(Book book) {
        books.add(book);
        return book;
    }

    @Override
    public List<Book> findAll() {
        return books;
    }
}
