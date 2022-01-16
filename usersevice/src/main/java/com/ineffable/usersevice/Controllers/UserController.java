package com.ineffable.usersevice.Controllers;
import com.ineffable.usersevice.DTO.UserWrapper;
import com.ineffable.usersevice.Exceptions.UserNotFoundException;
import com.ineffable.usersevice.Models.User;
import com.ineffable.usersevice.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserWrapper userWrapper;

    @GetMapping("")
    public UserWrapper getAllUser(){
        userWrapper.setUserList(userService.getAll());
        return userWrapper;
    }

    @GetMapping("/userid={id}")
    public User getUserById(@PathVariable("id")Long id) throws UserNotFoundException {
        return userService.getUserById(id);
    }

    @GetMapping("/username={name}")
    public User getUserByUserName(@PathVariable("name")String userName) throws UserNotFoundException {
        return userService.getUserByUserName(userName);
    }

    @PostMapping("/add")
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }

    @DeleteMapping("/delete/userid={userid}")
    public void deleteUser(@PathVariable("userid") Long id) throws UserNotFoundException{
        userService.deleteUser(id);
    }

}
