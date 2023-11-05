package com.example.sdp.service;

import com.example.sdp.entity.Farmer;
import com.example.sdp.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface userInterface  {
    Users findByUsername(String username, String password);
    Users findByUsername(String username);
    Object save(Users users);
    List<Users> getAllUsers();
	Object save(Farmer users);
}
