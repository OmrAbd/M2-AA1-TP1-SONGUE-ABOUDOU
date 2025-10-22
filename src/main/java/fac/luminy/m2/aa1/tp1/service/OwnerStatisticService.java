package fac.luminy.m2.aa1.tp1.service;

import fac.luminy.m2.aa1.tp1.model.entity.Location;
import fac.luminy.m2.aa1.tp1.model.entity.Proprietaire;
import fac.luminy.m2.aa1.tp1.model.entity.Voiture;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

@Component
@Slf4j
@AllArgsConstructor
public class OwnerStatisticService {

    public double recupererChiffreDAffaireGlobal(Proprietaire proprietaire){
        double chiffreDAffaire = 0;
        for(Voiture voiture : proprietaire.getVoituresPossedees()){
            for(Location location : voiture.getLocations()){
                chiffreDAffaire += location.getNombreDeJour()* voiture.getPrix();
            }
        }
        return chiffreDAffaire;
    }

    public double recupererTauxLocationAnneeEnCours(Proprietaire proprietaire){
        double somme = 0;
        long nombreVoiture = 0;
        for(Voiture voiture : proprietaire.getVoituresPossedees()){
            somme += recupererTauxLocationAnneeEnCours(voiture);
            nombreVoiture++;
        }
        return somme / nombreVoiture;
    }

    public double recupererTauxLocationAnneeEnCours(Voiture voiture){
        long nombreDeJoursEcouleAnneeEnCours = LocalDate.now().getDayOfYear();
        LocalDate startYear = LocalDate.of(LocalDate.now().getYear(),0,0);
        LocalDate endYear = LocalDate.of(LocalDate.now().getYear(),12,31);
        for (Location location : voiture.getLocations()){
            LocalDate startLocation = location.getStartDate();
            LocalDate endLocation = location.getEndDate();

            LocalDate overlapStart = startYear.isAfter(startLocation) ? startYear : startLocation;
            LocalDate overlapEnd = endYear.isBefore(endLocation) ? endYear : endLocation;
            long overlapDays = 0;
            if (!overlapEnd.isBefore(overlapStart)) {
                overlapDays = ChronoUnit.DAYS.between(overlapStart, overlapEnd.plusDays(1));
            }

            overlapDays / nombreDeJoursEcouleAnneeEnCours

                    // TODo : add for every location and returns the sum
        }
    }

    public double recupererTauxDeLocationAnnuel(Proprietaire owner){

    }

}
