package com.restful1.restful1.Controller;

import com.restful1.restful1.Entity.User;
import com.restful1.restful1.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController
{
    @Autowired
    UserService userService;

    @GetMapping("/")
    public String home(@RequestParam(value = "name", defaultValue = "World") String name,
                       @RequestParam(value = "msg", defaultValue = "Good Morning") String msg)
    {
        return "Hello " + name + ". " + msg;
    }

    @GetMapping("/users")
    public List<User> getUsers()
    {
        return this.userService.getAllUsers();
    }

    @GetMapping("/users/{userID}")
    public User getUser(@PathVariable String userID)
    {
        return this.userService.getUserById(Integer.parseInt(userID));
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user)
    {
        return this.userService.addUser(user);
    }

    @PutMapping("/users")
    public User updateCourse(@RequestBody User user)
    {
        return this.userService.updateUser(user);
    }

    @DeleteMapping("/users/{userID}")
    public String deleteUserById(@PathVariable String userID) { return this.userService.deleteUserById(Integer.parseInt(userID)); }

}
