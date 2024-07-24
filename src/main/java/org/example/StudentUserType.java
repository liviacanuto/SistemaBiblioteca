package org.example;

public class StudentUserType extends User {
    public StudentUserType(int id, String name, int age) {
        super(id, name, age);
        this.studentLoanLimit = loanLimit;
    }

    @Override
    public int getLoanLimit() {
        return ConfigurationManager.maxStudentLoanLimit;
    }

    @Override
    public String toString() {
        return "StudentUserType{" + "id=" + this.getId() + ", name='" + this.getName() + ", age='" + this.getAge() + ", loanLimit=" + this.getLoanLimit() + '\'' + '}';
    }
}