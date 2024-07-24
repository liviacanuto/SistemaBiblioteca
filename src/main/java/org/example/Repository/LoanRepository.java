package org.example.Repository;

import org.example.Book;
import org.example.Loan;
import org.example.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class LoanRepository implements ILoanRepository
{
    private List<Loan> loans = new ArrayList<>();
    private static LoanRepository singleton;

    private LoanRepository(){}

    public static LoanRepository loanRepositorySingleton() {
        if(singleton == null) {
            singleton = new LoanRepository();
        }
        return singleton;
    }

    @Override
    public Loan loan(User user, Book book)
    {
        Loan loan = new Loan(user, book, new Date());
        loans.add(loan);
        return loan;
    }

    @Override
    public Boolean returnBook(int bookID)
    {
        Loan loan = findOpenLoanByBookID(bookID);
        if(loan != null) {
            loan.setReturnDate(new Date());
            return true;
        }
        return false;
    }

    @Override
    public List<Loan> listOpenLoanByUserID(int userID)
    {
        return loans.stream().filter(a -> a.getUser().getId() == userID && a.getReturnDate() == null).collect(Collectors.toList());
    }

    @Override
    public List<Loan> listUserHistory(int userID)
    {
        return loans.stream().filter(loan -> loan.getUser().getId() == userID).collect(Collectors.toList());
    }

    @Override
    public Loan findOpenLoanByBookID(int bookID)
    {
         return loans.stream().filter(loan -> loan.getBook().getId() == bookID && loan.getReturnDate() == null).findFirst().orElse(null);
    }
}
