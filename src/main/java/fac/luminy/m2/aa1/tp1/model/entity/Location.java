package fac.luminy.m2.aa1.tp1.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

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
    private Client locataire;

    @NotNull
    @ManyToOne
    private Voiture voiture;

    @NotNull
    private LocalDate startDate;

    @NotNull
    @Min(value = 1)
    private int nombreDeJour = 1;

    public LocalDate getEndDate(){
        return startDate.plusDays(nombreDeJour);
    }

}
