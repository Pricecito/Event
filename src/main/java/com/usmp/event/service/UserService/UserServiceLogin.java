package com.usmp.event.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usmp.event.persistence.repository.UsersRepository;

@Service("loginService")
public class UserServiceLogin {

    @Autowired
    private UsersRepository repository;

    public boolean findEmail(String email) throws NullPointerException {
        for (var u : repository.findAll()) {
            if (u.getEmail().equals(email))
                return true;
        }
        throw new NullPointerException();

    }

    public boolean findPassword(String password) throws NullPointerException {
        for (var u : repository.findAll()) {
            if (u.getPassword().equals(password))
                return true;
        }
        throw new NullPointerException();

    }

}
