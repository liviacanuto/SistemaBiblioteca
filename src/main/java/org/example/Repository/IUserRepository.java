package org.example.Repository;

import org.example.User;

import java.util.List;

public interface IUserRepository
{
    User findUser(int id);
    User addStudent(String name, int age);
    User addTeacher(String name, int age);
    List<User> findAll();
}
