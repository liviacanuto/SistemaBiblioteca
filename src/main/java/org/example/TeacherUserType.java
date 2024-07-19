public class TeacherUserType extends User{

    private int teacherLoanLimit;

    public TeacherUserType(int id, String name, int age, int loanLimit){
        super(id, name, age);
        this.teacherLoanLimit = loanLimit;
    }

     @Override
    public String toString()
    {
        return "User{" + "id=" + id + ", name='" + name + ", age='" + age ", loanLimit='" + teacherLoanLimit + '\'' + '}';
    }
}