package com.usmp.event.persistence.models;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true, nullable = false)
    private String username;
    private String email;
    private String password;
    @Column(nullable = false, unique = true)
    private String dni;

    @Column(nullable = false)
    private LocalDate fechaNacimiento;

    private Integer edad;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private Set<Roles> roles = new HashSet<>();

    public Integer calcularEdad() throws Exception {
        LocalDate actual = LocalDate.now();
        int edad = Period.between(this.fechaNacimiento, actual).getYears();
        if (edad < 18) {
            throw new Exception();
        } else
            return edad;

    }

}