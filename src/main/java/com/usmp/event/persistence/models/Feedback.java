package com.usmp.event.persistence.models;


import java.util.UUID;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "feedback")
public class Feedback {
    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    private UUID id;

    private Byte calification;

    private String comment;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Events evento;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users usuario;
    
}