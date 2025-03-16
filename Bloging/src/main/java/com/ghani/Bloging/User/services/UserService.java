package com.ghani.Bloging.User.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ghani.Bloging.User.DAO.UserRepo;
import com.ghani.Bloging.User.model.User;

@Service
public class UserService {

    private UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    // all CRUD methods
    public List<User> getUsers() {
        return userRepo.findAll();
    }

    public User addUser(User user) {
        return userRepo.save(user);
    }

    public User getUserById(Long id) {
        return userRepo.findById(id).orElse(new User());
    }

    public User updateUser(User user) {
        return userRepo.save(user);
    }

    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }

}
