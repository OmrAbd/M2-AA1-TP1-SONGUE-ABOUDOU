package fac.luminy.m2.aa1.tp1.model.dto;

import fac.luminy.m2.aa1.tp1.model.entity.Location;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocationDTO {
    private Long id;
    private PersonneDTO locataire;
    private VoitureDTO voiture;
    private PersonneDTO proprietaire;
    private int nombreDeJour;

    public LocationDTO(Location location){
        this.id = location.getId();
        this.locataire = new PersonneDTO(location.getLocataire());
        this.voiture = new VoitureDTO(location.getVoiture());
        this.proprietaire = new PersonneDTO(location.getProprietaire());
        this.nombreDeJour = location.getNombreDeJour();
    }
}
