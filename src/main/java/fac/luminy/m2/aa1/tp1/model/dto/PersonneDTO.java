package fac.luminy.m2.aa1.tp1.model.dto;

import fac.luminy.m2.aa1.tp1.model.entity.Personne;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Classe representant une personne, utilisée pour la communication avec l'extérieur.
 * @author matmiche
 */
@Getter
@Setter
public class PersonneDTO {
    private Long id;
    private String nom;
    private String prenom;
    private String adresse;
    private String codePostal;
    private String email;
    private List<VoitureDTO> voituresPossedees;
    private List<LocationDTO> locationEnTantQueVendeur;
    private List<LocationDTO> locationEnTantQueClient;

    /**
     * Construit un nouveau PersonneDTO à partir d'une entité Personne donnée.
     *
     * @param personne l'entité {@link Personne} à convertir en PersonneDTO
     */
    public PersonneDTO(Personne personne){
        this.id = personne.getId();
        this.nom = personne.getNom();
        this.prenom = personne.getPrenom();
        this.adresse = personne.getAdresse();
        this.codePostal = personne.getCodePostal();
        this.email = personne.getEmail();
        this.voituresPossedees = personne.getVoituresPossedees() == null ? null :
                personne.getVoituresPossedees()
                        .stream()
                        .map(VoitureDTO::new)
                        .toList();
        this.locationEnTantQueVendeur = personne.getLocationsEnTantQueVendeur() == null ? null :
                personne.getLocationsEnTantQueVendeur()
                        .stream()
                        .map(LocationDTO::new)
                        .toList();
        this.locationEnTantQueClient = personne.getLocationsEnTantQueClient() == null ? null :
                personne.getLocationsEnTantQueClient()
                        .stream()
                        .map(LocationDTO::new)
                        .toList();
    }
}
