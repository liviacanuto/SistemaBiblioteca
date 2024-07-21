package org.example.ApprovalHandler;


import org.example.Repository.IUserRepository;
import org.example.Repository.UserRepository;
import org.example.User;


public class UserEligibilityHandler extends ApprovalHandler {
    private ApprovalHandler next = new LoanLimitHandler();
    private IUserRepository userRep = UserRepository.userRepositorySingleton();

    @Override
    public boolean checkAvailability(int userID, int bookID) {
        User user = userRep.findUser(userID);
        if(user == null || user.getAge() < 10) {
            return false;
        }
        return next.checkAvailability(userID, bookID);
    }
}
