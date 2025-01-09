package com.usmp.event.service.UserService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usmp.event.persistence.models.Users;
import com.usmp.event.persistence.repository.UsersRepository;

@Service
public class UserService {
    @Autowired
    private UsersRepository repository;

    public List<Users> findAllUsers() {
        return repository.findAll();
    }

    public Optional<Users> findOneUser(UUID id) {
        return repository.findById(id);
    }

    public Users saveOrUpdateUser(Users user) {
        repository.save(user);
        return user;
    }

    public void deleteUser(UUID id) {
        repository.deleteById(id);
    }

    public boolean findEmail(String email) {
        for (var u : repository.findAll()) {
            if (u.getEmail().equals(email))
                return true;
        }
        throw new NullPointerException();

    }

    public boolean findPassword(String password) {
        for (var u : repository.findAll()) {
            if (u.getPassword().equals(password))
                return true;
        }
        throw new NullPointerException();

    }

}