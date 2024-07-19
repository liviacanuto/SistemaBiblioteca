public class StudentUserType extends User{
    private int studentLoanLimit;
    
    public StudentUserType(int id, String name, int age, int loanLimit){
        super(id, name, age);
        this.teacherLoanLimit = loanLimit;
    }

     @Override
    public String toString()
    {
        return "User{" + "id=" + id + ", name='" + name + ", age='" + age ", loanLimit='" + studentLoanLimit + '\'' + '}';
    }
}