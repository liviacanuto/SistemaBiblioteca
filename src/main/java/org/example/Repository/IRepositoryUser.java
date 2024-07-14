package org.example.Repository;

import org.example.User;

public interface IRepositoryUser
{
    User findUser(int id);
    User addUser(String name);
}
