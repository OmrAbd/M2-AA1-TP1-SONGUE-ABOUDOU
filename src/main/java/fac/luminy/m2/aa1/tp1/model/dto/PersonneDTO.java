package fac.luminy.m2.aa1.tp1.model.dto;

import fac.luminy.m2.aa1.tp1.model.entity.Personne;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Classe representant une personne, utilisée pour la communication avec l'extérieur.
 * @author matmiche
 */
@Data
@NoArgsConstructor
public class PersonneDTO {
    private Long id;
    private String nom;
    private String prenom;
    private String adresse;
    private String codePostal;
    private String email;
/*    private List<VoitureDTO> voituresPossedees;
    private List<LocationDTO> locationEnTantQueVendeur;*/
//    private List<LocationDTO> locationEnTantQueClient;

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
    }
}
