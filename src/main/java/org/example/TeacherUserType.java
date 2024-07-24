package org.example;

public class TeacherUserType extends User{
    public TeacherUserType(int id, String name, int age){
        super(id, name, age);
    }

    @Override
    public int getLoanLimit() {
        return ConfigurationManager.maxTeacherLoanLimit;
    }

    @Override
    public String toString()
    {
        return "TeacherUserType{" + "id=" + this.getId() + ", name='" + this.getName() + ", age='" + this.getAge() + ", loanLimit='" + this.getLoanLimit() + '\'' + '}';
    }
}