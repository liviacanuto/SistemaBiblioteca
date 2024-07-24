package org.example.ApprovalHandler;

import org.example.Repository.ILoanRepository;
import org.example.Repository.LoanRepository;
import org.example.Loan;

import java.util.List;

public class LoanLimitHandler extends ApprovalHandler {
    ILoanRepository repLoan = LoanRepository.loanRepositorySingleton();

    @Override
    public boolean checkAvailability(int userID, int bookID) {
        List<Loan> loans = repLoan.listOpenLoanByUserID(userID);
        boolean isEmpty = loans.isEmpty();
        boolean atingiuLimite = !isEmpty && loans.get(0).getUser().getLoanLimit() <= loans.size();
        if(atingiuLimite) {
            System.out.println("O usuário passou do limite de alugueis!");
        }
        return !atingiuLimite;
    }
}
