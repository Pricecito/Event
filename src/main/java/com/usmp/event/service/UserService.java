package com.usmp.event.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usmp.event.persistence.models.Roles;
import com.usmp.event.persistence.models.Users;
import com.usmp.event.persistence.repository.IUsersRepository;

@Service
public class UserService {
    @Autowired
    private IUsersRepository repository;
    @Autowired
    private RolService rol_Service;

    public List<Users> findAllUsers() {
        return repository.findAll();
    }

    public Optional<Users> findOneUser(UUID id) {
        return repository.findById(id);
    }

    public Users saveOrUpdateUser(Users user) {
        List<Roles> rol = rol_Service.findAllRoles().stream().filter(x -> x.getRolEnum().name().equals("USUARIO"))
                .toList();
        user.setRoles(new HashSet<>(rol));
        repository.save(user);
        return user;
    }

    public void deleteUser(UUID id) {
        repository.deleteById(id);
    }

    public Users findEmailAndPassword(Users user) {
        for (var u : repository.findAll()) {
            if (u.getEmail().equals(user.getEmail()))
                if (u.getPassword().equals(user.getPassword()))
                    return u;
        }
        return null;

    }

}
