package org.example.ApprovalHandler;

import org.example.Book;
import org.example.Repository.BookRepository;
import org.example.Repository.IBookRepository;

public class BookAvailabilityHandler extends ApprovalHandler {
    private ApprovalHandler next = new UserEligibilityHandler();
    private IBookRepository bookRep = BookRepository.bookRepositorySingleton();

    @Override
    public boolean checkAvailability(int userID, int bookID) {
        Book book = bookRep.searchById(bookID);
        if(book == null || !book.isAvailable()) {
            return false;
        }
        return next.checkAvailability(userID, bookID);
    }
}
