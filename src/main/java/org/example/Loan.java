package org.example;

import java.util.Date;

public class Loan
{
    private User user;
    private Book book;
    private Date loanDate;
    private Date returnDate;

    public Loan(User user, Book book, Date loanDate)
    {
        this.user = user;
        this.book = book;
        this.loanDate = loanDate;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public Book getBook()
    {
        return book;
    }

    public void setBook(Book book)
    {
        this.book = book;
    }

    public Date getLoanDate()
    {
        return loanDate;
    }

    public void setLoanDate(Date loanDate)
    {
        this.loanDate = loanDate;
    }

    public Date getReturnDate()
    {
        return returnDate;
    }

    public void setReturnDate(Date returnDate)
    {
        this.returnDate = returnDate;
    }

    @Override
    public String toString()
    {
        return "\n\nLoan{" + "\nuser=" + user + ", \nbook=" + book + ", \nloanDate=" + loanDate + ", \nreturnDate=" + returnDate + "\n}";
    }
}
