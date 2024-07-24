package org.example;

import org.example.ExternalBook.ExternalBookAdapter;
import org.example.Repository.BookRepository;
import org.example.Repository.IBookRepository;
import org.example.Repository.ILoanRepository;
import org.example.Repository.IUserRepository;
import org.example.Repository.LoanRepository;
import org.example.Repository.UserRepository;

public class CenarioManager {
    static IBookRepository repBook = BookRepository.bookRepositorySingleton();
    static IUserRepository repUser = UserRepository.userRepositorySingleton();
    static ILoanRepository repLoan = LoanRepository.loanRepositorySingleton();


    private static void popularRepBook() {
        Category a1 = new Category("Ficção");
        Category a2 = new Category("Ficção Científica");
        Category a3 = new Category("Distopia");
        a2.addCategory(a3);
        a1.addCategory(a2);

        Category b1 = new Category("Fantasia");
        Category b2 = new Category("Epico");
        b1.addCategory(b2);

        repBook.addNewBook("1984", "George Orwell", a1);
        repBook.addNewBook("Neuromancer", "William Gibson", a1);
        repBook.addNewBook("Snow Crash", "Neal Stephenson", a2);
        repBook.addNewBook("O Senhor dos Anéis", "J.R.R. Tolkien", b1);
        repBook.addNewBook("A Guerra dos Tronos", "George R.R. Martin", b1);
        repBook.addNewBook("A Divina Comédia", "Dante Alighieri", b2);

        Book ex1 = new ExternalBookAdapter(1, "O Conto da Aia", true, "Margaret Atwoodim", a2);
        Book ex2 = new ExternalBookAdapter(2, "Snow Crash", true, "Neal Stephenson", a3);
        repBook.addNewBook(ex1);
        repBook.addNewBook(ex2);
    }

    private static void popularUser() {
        repUser.addStudent("Hermione Granger", 17);
        repUser.addStudent("Harry Potter", 17);
        repUser.addStudent("Ron Weasley", 9);
        repUser.addStudent("Draco Malfoy", 17);
        repUser.addStudent("Luna Lovegood", 16);

        repUser.addTeacher("Albus Dumbledore", 115);
        repUser.addTeacher("Minerva McGonagall", 70);
        repUser.addTeacher("Severus Snape", 38);
    }

    private static void popularLoan() {
        LibraryFacade m = new LibraryMediator();
        m.borrowBook(1001,1);
        m.borrowBook(1002,1);
        m.borrowBook(1003,1);
        m.borrowBook(1,6);
    }

    private static void popularNotifier() {
        ConfigurationManager.notifier.subscribe(repUser.findUser(6));
    }

    public static void popularBanco() {
        popularRepBook();
        popularUser();
        popularLoan();
        popularNotifier();
    }
}
