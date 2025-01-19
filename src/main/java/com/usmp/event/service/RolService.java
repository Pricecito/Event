package com.usmp.event.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usmp.event.persistence.models.Roles;
import com.usmp.event.persistence.repository.RolesRepository;

@Service
public class RolService {

    @Autowired
    private RolesRepository repository;

    public List<Roles> findAllRoles() {
        return repository.findAll();
    }

    public Optional<Roles> findOneRole(Long id) {
        return repository.findById(id);
    }

    public Roles saveOrUpdateRole(Roles role) {
        return repository.save(role);
    }

    public void deleteRole(Long id) {
        repository.deleteById(id);
    }
}
