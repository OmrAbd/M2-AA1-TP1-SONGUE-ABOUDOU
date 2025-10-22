package fac.luminy.m2.aa1.tp1.model.dto;

import fac.luminy.m2.aa1.tp1.model.entity.Location;
import lombok.Data;

import java.time.LocalDate;

@Data
public class LocationDTO {
    private Long id;
    private ClientDTO locataire;
    private VoitureDTO voiture;
    private LocalDate startDate;
    private int nombreDeJour;

    public LocationDTO(Location location){
        this.id = location.getId();
        this.locataire = new ClientDTO(location.getLocataire());
        this.voiture = new VoitureDTO(location.getVoiture());
        this.startDate = location.getStartDate();
        this.nombreDeJour = location.getNombreDeJour();
    }
}
