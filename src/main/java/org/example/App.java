package org.example;

import org.example.ApprovalHandler.ApprovalHandler;
import org.example.ApprovalHandler.BookAvailabilityHandler;
import org.example.Repository.*;

public class App
{
    public static void main( String[] args )
    {
        IBookRepository repBook = BookRepository.bookRepositorySingleton();
        IUserRepository repUser = UserRepository.userRepositorySingleton();
        ILoanRepository repLoan = LoanRepository.loanRepositorySingleton();
        ApprovalHandler approvalHandler = new BookAvailabilityHandler();

        Category category = new Category("category");
        Category c1 = new Category("c1");
        Category c2 = new Category("c2");

        c1.addCategory(c2);
        category.addCategory(c1);

        Book l1 = repBook.addNewBook("aa", "eu", category);
        Book l2 = repBook.addNewBook("aa", "eu", category);
        Book l3 = repBook.addNewBook("aa", "eu", category);
        Book l4 = repBook.addNewBook("aa", "eu", category);

        repUser.addStudent("momo", 10);

        System.out.println((approvalHandler.checkAvailability(1,1)));
        repLoan.loan(repUser.findUser(1), repBook.searchById(1));
        repLoan.loan(repUser.findUser(1), repBook.searchById(2));
        repLoan.loan(repUser.findUser(1), repBook.searchById(3));
        System.out.println((approvalHandler.checkAvailability(1,4)));
    }
}
