package org.example.Repository;

import org.example.Book;
import org.example.Loan;
import org.example.User;

import java.util.List;

public interface ILoanRepository
{
    Loan loan(User user, Book book);
    Boolean returnBook(int bookID);
    List<Loan> listOpenLoanByUserID(int userID);
    List<Loan> listUserHistory(int userID);
    Loan findOpenLoanByBookID(int bookID);
}
