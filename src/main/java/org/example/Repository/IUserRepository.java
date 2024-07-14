package org.example.Repository;

import org.example.User;

public interface IUserRepository
{
    User findUser(int id);
    User addUser(String name);
}
