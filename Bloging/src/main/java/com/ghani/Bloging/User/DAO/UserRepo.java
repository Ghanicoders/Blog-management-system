package com.ghani.Bloging.User.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ghani.Bloging.User.model.User;

public interface UserRepo extends JpaRepository<User, Long> {

}
