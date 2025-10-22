package fac.luminy.m2.aa1.tp1.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "CLIENT")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Client extends Personne{

    @OneToMany(mappedBy = "locataire", fetch = FetchType.LAZY)
    private List<Location> locationsEnTantQueClient = List.of();
}
