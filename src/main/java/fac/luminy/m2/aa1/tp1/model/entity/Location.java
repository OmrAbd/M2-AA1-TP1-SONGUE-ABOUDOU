package fac.luminy.m2.aa1.tp1.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Location{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @ManyToOne
    private Personne locataire;

    @NotNull
    @ManyToOne
    private Voiture voiture;

    @NotNull
    @ManyToOne
    private Personne proprietaire;

    @NotNull
    private int nombreDeJour = 1;

    @PrePersist
    @PreUpdate
    private void syncProprietaire() {
        if (voiture != null)
            proprietaire = voiture.getProprietaire();
    }
}
