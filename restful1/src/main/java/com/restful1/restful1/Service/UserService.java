package com.restful1.restful1.Service;

import com.restful1.restful1.Entity.User;

import java.util.List;

public interface UserService
{
    List<User> getAllUsers();
    User getUserById(int userId);
    User addUser(User user);
    User updateUser(User user);
    String deleteUserById(int userID);
}
