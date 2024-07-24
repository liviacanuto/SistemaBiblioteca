package org.example.ApprovalHandler;

public abstract class ApprovalHandler {
    protected ApprovalHandler next;

    public abstract boolean checkAvailability(int userID, int bookID);
}
