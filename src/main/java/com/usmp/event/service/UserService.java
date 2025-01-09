package com.usmp.event.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usmp.event.persistence.models.Users;
import com.usmp.event.persistence.repository.UsersRepository;

@Service
public class UserService {
    @Autowired
    private UsersRepository repository;

    public List<Users> findAllUsers(){
        
        return repository.findAll();
    }
}
