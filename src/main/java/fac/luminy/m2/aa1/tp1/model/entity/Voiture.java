package fac.luminy.m2.aa1.tp1.model.entity;

import fac.luminy.m2.aa1.tp1.model.TypeVoiture;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity(name = "VOITURE")
public class Voiture {
    @Id
    @GeneratedValue
    private Long id;
    private String modele;
    private String marque;
    private int annee;
    @Enumerated(EnumType.STRING)
    private TypeVoiture type;
    private int chevauxFiscaux;
    private double prix;
    private double consommation;
    private String couleur;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Personne proprietaire;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Location> locations = List.of();

}
