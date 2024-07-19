package org.example;

import org.example.Repository.*;

import java.util.List;

public class LibraryMediator implements LibraryFacade
{
    private IUserRepository userRepository = UserRepository.userRepositorySingleton();
    private ILoanRepository loanRepository = LoanRepository.loanRepositorySingleton();
    private IBookRepository bookRepository = BookRepository.bookRepositorySingleton();

    @Override
    public Book searchBook(int bookID) {
        return bookRepository.searchById(bookID);
    }

    @Override
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

    @Override
    public List<Loan> userLoanHistory(int userID) {
        return loanRepository.listUserHistory(userID);
    }

    @Override
    public List<Loan> userOpenLoansByUserID(int userID) {
        return loanRepository.listOpenLoanByUserID(userID);
    }

    @Override
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
