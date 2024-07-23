package org.example;

public class App {
    public static void main(String[] args) {
        CenarioManager.popularBanco();
        LibraryFacade mediator = new LibraryMediator();

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

        System.out.println("\n******ENCONTRAR USUARIOS + HISTÓRICO DE EMPRÉSTIMO*******");
        System.out.println(mediator.userLoanHistory(1));
    }
}
