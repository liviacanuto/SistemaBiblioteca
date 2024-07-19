public interface LibraryFacade{
    public Book searchBook();
    public boolean borrowBook();
    public List<Loan> userLoanHistory();
    public List<Loan> userOpenLoansByUserID();
    public boolean returnBook();
}