package fac.luminy.m2.aa1.tp1.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "VENDEUR")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Proprietaire extends Personne{

    @OneToMany(mappedBy = "proprietaire", fetch = FetchType.LAZY)
    private List<Voiture> voituresPossedees = List.of();

}
