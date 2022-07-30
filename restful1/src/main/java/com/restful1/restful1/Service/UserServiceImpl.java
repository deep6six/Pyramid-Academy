package com.restful1.restful1.Service;

import com.restful1.restful1.DAO.UserDAO;
import com.restful1.restful1.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserDAO userDAO;

    @Override
    public List<User> getAllUsers()
    {
        return this.userDAO.findAll();
    }

    @Override
    public User getUserById(int userId)
    {
        Optional<User> u = this.userDAO.findById(userId);
        User user = null;
        if(u.isPresent()) { user = u.get(); }
        else { throw new RuntimeException("User not found for ID:: " + userId); }
        return user;
    }

    @Override
    public User addUser(User user)
    {
        return this.userDAO.save(user);
    }

    @Override
    public User updateUser(User user)
    {
        return this.userDAO.save(user);
    }

    @Override
    public String deleteUserById(int userID)
    {
        this.deleteUserById(userID);
        return "Deleted Successfully";
    }
}
