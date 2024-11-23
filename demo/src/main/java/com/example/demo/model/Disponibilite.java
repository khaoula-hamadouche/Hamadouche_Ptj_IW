package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
public class Disponibilite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "L'identifiant du professionnel est obligatoire")
    private Long professionnelId;

    @NotNull(message = "La date de début est obligatoire")
    private LocalDateTime debut;

    @NotNull(message = "La date de fin est obligatoire")
    private LocalDateTime fin;
}
