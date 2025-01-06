package com.usmp.event.persistence.models;

import javax.persistence.*;
import java.io.Serializable;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "users")
public class Users implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="users_sequence")
    @SequenceGenerator(name="users_sequence", sequenceName="users_sequence", allocationSize=100)
    private Long id;
    
}