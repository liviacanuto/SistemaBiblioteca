package org.example.Repository;

import org.example.StudentUserType;
import org.example.TeacherUserType;
import org.example.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository implements IUserRepository
{
    private List<User> users = new ArrayList<>();
    private static UserRepository singleton;
    private int id = 1;

    private UserRepository(){}

    public static UserRepository userRepositorySingleton() {
        if(singleton == null) {
            singleton = new UserRepository();
        }
        return singleton;
    }


    @Override
    public User findUser(int id)
    {
        Optional<User> user = users.stream().filter(u -> u.getId() == id).findFirst();
        return user.orElse(null);
    }

    @Override
    public User addStudent(String name, int age) {
        User student = new StudentUserType(id++, name, age);
        return addUser(student);
    }

    @Override
    public User addTeacher(String name, int age) {
        User teacher = new TeacherUserType(id++, name, age);
        return addUser(teacher);
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    private User addUser(User user)
    {
        users.add(user);
        return user;
    }
}
