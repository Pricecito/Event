package com.usmp.event.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usmp.event.persistence.models.Roles;

public interface IRolesRepository extends JpaRepository<Roles, Long> {

    

}
