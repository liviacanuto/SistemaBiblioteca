package org.example.Repository;

import org.example.Book;
import org.example.Loan;
import org.example.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class LoanRepository implements ILoanRepository
{
    private List<Loan> loans = new ArrayList<>();

    @Override
    public Loan rent(User user, Book book)
    {
        Loan loan = new Loan(user, book, new Date());
        loans.add(loan);
        return loan;
    }

    @Override
    public Boolean returnBook(int bookID)
    {
        Optional<Loan> al = loans.stream().filter(loan -> loan.getBook().getId() == bookID && loan.getReturnDate() == null).findFirst();
        if(al.isPresent()) {
            al.get().setReturnDate(new Date());
            return true;
        }
        return false;
    }

    @Override
    public List<Loan> listOpenRentByUser(int userID)
    {
        return loans.stream().filter(a -> a.getUser().getId() == userID && a.getReturnDate() == null).collect(Collectors.toList());
    }

    @Override
    public List<Loan> listUserHistory(int userID)
    {
        return loans.stream().filter(loan -> loan.getUser().getId() == userID).collect(Collectors.toList());
    }
}
