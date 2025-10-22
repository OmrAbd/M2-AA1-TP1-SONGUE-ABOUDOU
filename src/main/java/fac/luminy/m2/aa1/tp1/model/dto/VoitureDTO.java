package fac.luminy.m2.aa1.tp1.model.dto;

import fac.luminy.m2.aa1.tp1.model.TypeVoiture;
import fac.luminy.m2.aa1.tp1.model.entity.Voiture;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Classe representant une voiture, utilisée pour la communication avec l'extérieur.
 *
 * @author matmiche
 */
@Setter
@Getter
@AllArgsConstructor
public class VoitureDTO {

    private Long id;
    private String modele;
    private String marque;
    private int annee;
    private TypeVoiture type;
    private int chevauxFiscaux;
    private double prix;
    private double consommation;
    private String couleur;
    private VendeurDTO proprietaire;

    public VoitureDTO(Voiture voiture) {
        this.id = voiture == null ? null : voiture.getId();
        this.modele = voiture == null ? null : voiture.getModele();
        this.marque = voiture == null ? null : voiture.getMarque();
        this.annee = voiture == null ? 0 : voiture.getAnnee();
        this.type = voiture == null ? TypeVoiture.NULL_TYPE : voiture.getType();
        this.chevauxFiscaux = voiture == null ? 0 : voiture.getChevauxFiscaux();
        this.prix = voiture == null ? 0 : voiture.getPrix();
        this.consommation = voiture == null ? 0 : voiture.getConsommation();
        this.couleur = voiture == null ? null : voiture.getCouleur();
        this.proprietaire = new VendeurDTO(voiture.getProprietaire());
    }

}
