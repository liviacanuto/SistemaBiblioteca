package org.example.Repository;

import org.example.Book;
import org.example.Loan;
import org.example.User;

import java.util.List;

public interface ILoanRepository
{
    Loan rent(User user, Book book);
    Boolean returnBook(int bookID);
    List<Loan> listOpenRentByUser(int userID);
    List<Loan> listUserHistory(int userID);
}
