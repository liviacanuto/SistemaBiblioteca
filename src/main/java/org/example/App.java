package org.example;

import org.example.Repository.*;

public class App
{
    public static void main( String[] args )
    {
        IBookRepository repBook = new BookRepository();
        IRepositoryUser repUser = new UserRepository();
        ILoanRepository repLoan = new LoanRepository();
        Book l1 = repBook.addNewBook("aa", "eu");
        User u1 = repUser.addUser("livia");
        Book found = repBook.searchById(l1.getId());
        System.out.println( found );
        System.out.println( repBook.borrowBook(l1.getId()));
        System.out.println( repBook.borrowBook(l1.getId()));
        System.out.println( u1 );
        System.out.println(repUser.findUser(u1.getId()));

        Loan loan = repLoan.rent(u1,l1);
        System.out.println(loan);
        System.out.println(repLoan.listOpenRentByUser(u1.getId()));
        System.out.println(repLoan.returnBook(l1.getId()));
        System.out.println(repLoan.listOpenRentByUser(u1.getId()));
        System.out.println(repLoan.listUserHistory(u1.getId()));


    }
}
