package org.example;

import java.util.List;

public interface LibraryFacade{
    Book searchBook(int bookID);
    boolean borrowBook(int bookID, int userID);
    List<Loan> userLoanHistory(int userID);
    List<Loan> userOpenLoansByUserID(int userID);
    boolean returnBook(int bookID);
}