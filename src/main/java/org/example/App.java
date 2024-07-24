package org.example;

import org.example.ExternalBook.BookAdapter;
import org.example.ExternalBook.ExternalBookAdapter;

public class App {
    public static void main(String[] args) {
        CenarioManager.popularBanco();
        LibraryFacade mediator = new LibraryMediator();
        BookAdapter ex1 = new ExternalBookAdapter(3, "Livro externo", true,"Autor", new Category("Externo"));

        System.out.println("******INICIO DOS TESTES*******");
        System.out.println("\n****** EMPRÉSTIMO DE LIVRO *******");
        mediator.borrowBook(1004,1);
        mediator.borrowBook(1001,2);
        mediator.borrowBook(1005,3);
        mediator.borrowBook(1005,4);

        System.out.println("\n******DEVOLVER LIVROS*******");
        mediator.returnBook(1001);

        System.out.println("\n******ENCONTRAR LIVROS + DETALHES*******");
        System.out.println(mediator.searchBook(1001));

        System.out.println("\n******VERIFICAR SE LIVRO EXTERNO POSSUI UMA CATEGORIA ESPECIFICA*******");
        System.out.println(ex1.temCategoria("Externo"));

        System.out.println("\n******ENCONTRAR USUARIOS + HISTÓRICO DE EMPRÉSTIMO*******");
        System.out.println(mediator.userLoanHistory(1));
    }
}
