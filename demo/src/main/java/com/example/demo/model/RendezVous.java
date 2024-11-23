package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
public class RendezVous {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "L'identifiant du client est obligatoire")
    private Long clientId;

    @NotNull(message = "L'identifiant du professionnel est obligatoire")
    private Long professionnelId;

    @NotNull(message = "La date et l'heure du rendez-vous sont obligatoires")
    private LocalDateTime dateHeure;

    private String statut; // Par exemple : "CONFIRME", "ANNULE"




}
