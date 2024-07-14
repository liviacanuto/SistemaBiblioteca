package org.example;

import org.example.Repository.*;

public class App
{
    public static void main( String[] args )
    {
        IBookRepository repBook = BookRepository.bookRepositorySingleton();
        IUserRepository repUser = UserRepository.userRepositorySingleton();
        ILoanRepository repLoan = LoanRepository.loanRepositorySingleton();
        Book l1 = repBook.addNewBook("aa", "eu");
        User u1 = repUser.addUser("livia");
        Book found = repBook.searchById(l1.getId());
        System.out.println( found );
        System.out.println( repBook.borrowBook(l1.getId()));
        System.out.println( repBook.borrowBook(l1.getId()));
        System.out.println( u1 );
        System.out.println(repUser.findUser(u1.getId()));

        Loan loan = repLoan.loan(u1,l1);
        System.out.println(loan);
        System.out.println(repLoan.listOpenLoanByUserID(u1.getId()));
        System.out.println(repLoan.returnBook(l1.getId()));
        System.out.println(repLoan.listOpenLoanByUserID(u1.getId()));
        System.out.println(repLoan.listUserHistory(u1.getId()));

        LibraryFacade facade = new LibraryFacade();
        System.out.println(facade.searchBook(l1.getId()) == l1);
    }
}
