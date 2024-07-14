package org.example;

public class Book
{
    private int id;
    private String title;
    private String author;
    private boolean available;

    public Book(int id, String title, boolean disponibilidade, String author)
    {
        this.id = id;
        this.title = title;
        this.available = disponibilidade;
        this.author = author;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public boolean isAvailable()
    {
        return available;
    }

    public void setAvailable(boolean available)
    {
        this.available = available;
    }

    @Override
    public String toString()
    {
        return "Book{" + "id=" + id + ", title='" + title + '\'' + ", author='" + author + '\'' + ", available=" + available + '}';
    }
}
