package com.usmp.event.persistence.repository;

import com.usmp.event.persistence.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface IUsersRepository extends JpaRepository<Users, UUID> {
    // Puedes agregar métodos personalizados aquí si es necesario
}
