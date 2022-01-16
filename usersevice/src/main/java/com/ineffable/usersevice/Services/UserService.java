package com.ineffable.usersevice.Services;

import com.ineffable.usersevice.Exceptions.UserNotFoundException;
import com.ineffable.usersevice.Models.User;
import com.ineffable.usersevice.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.desktop.OpenFilesEvent;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public List<User> getAll(){
        return userRepo.findAll();
    }


    public User getUserById(Long id) throws UserNotFoundException {
        Optional<User> user = userRepo.findById(id);
        if(user.isPresent()){
            return user.get();
        }else{
            throw  new UserNotFoundException("Get User By Id Failed");
        }
    }

    public void addUser(User user) {
        userRepo.save(user);
    }

    public void deleteUser(Long id) throws UserNotFoundException{
        if(userRepo.existsById(id)){
            userRepo.deleteById(id);
        }else {
            throw new UserNotFoundException("User deletion failed");
        }
    }

    public User getUserByUserName(String userName) throws UserNotFoundException{
        Optional<User> user = userRepo.findUserByUsername(userName);
        if(user.isPresent()){
            return user.get();
        }else {
            throw new UserNotFoundException("Cant Find User By UserName");
        }

    }
}
