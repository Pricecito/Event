package com.usmp.event.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usmp.event.persistence.models.Roles;

public interface RolesRepository extends JpaRepository<Roles, Long> {

    

}
