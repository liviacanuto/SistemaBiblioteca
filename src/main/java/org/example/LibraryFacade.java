package org.example;

import org.example.Repository.*;

import java.util.List;

public class LibraryFacade
{
    private IUserRepository userRepository = UserRepository.userRepositorySingleton();
    private ILoanRepository loanRepository = LoanRepository.loanRepositorySingleton();
    private IBookRepository bookRepository = BookRepository.bookRepositorySingleton();

    public Book searchBook(int bookID) {
        return bookRepository.searchById(bookID);
    }

    public boolean borrowBook(int bookID, int userID) {
        Book book = bookRepository.searchById(bookID);
        User user = userRepository.findUser(userID);
        if(book.isAvailable()) {
            bookRepository.borrowBook(bookID);
            loanRepository.loan(user, book);
            return true;
        }
        return false;
    }

    public List<Loan> userLoanHistory(int userID) {
        return loanRepository.listUserHistory(userID);
    }

    public List<Loan> userOpenLoansByUserID(int userID) {
        return loanRepository.listOpenLoanByUserID(userID);
    }

    public boolean returnBook(int bookID) {
        Loan loan = loanRepository.findOpenLoanByBookID(bookID);
        if(loan != null) {
            bookRepository.returnBook(bookID);
            loanRepository.returnBook(bookID);
            return true;
        }
        return false;
    }

}
