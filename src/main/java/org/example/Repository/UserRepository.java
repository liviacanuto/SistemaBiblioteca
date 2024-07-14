package org.example.Repository;

import org.example.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository implements IUserRepository
{
    private List<User> users = new ArrayList<>();
    private int id = 1;

    @Override
    public User findUser(int id)
    {
        Optional<User> user = users.stream().filter(u -> u.getId() == id).findFirst();
        return user.orElse(null);
    }

    @Override
    public User addUser(String nome)
    {
        User user = new User(id++, nome);
        users.add(user);
        return user;
    }
}
