package com.ineffable.usersevice.Repositories;

import com.ineffable.usersevice.Models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends CrudRepository<User, Long> {
    public List<User> findAll();
    public Optional<User> findUserByUsername(String userName);
}
