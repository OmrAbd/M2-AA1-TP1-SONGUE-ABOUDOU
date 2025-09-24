package fac.luminy.m2.aa1.tp1.service;


import fac.luminy.m2.aa1.tp1.model.TypeVoiture;
import fac.luminy.m2.aa1.tp1.model.dto.VoitureDTO;
import fac.luminy.m2.aa1.tp1.model.entity.Voiture;
import fac.luminy.m2.aa1.tp1.repository.VoitureRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class VoitureServiceTest {

    @Mock
    private VoitureRepository voitureRepository;

    @InjectMocks
    private VoitureService voitureService;

    @Test
    public void testGetVoitures() {
        // Arrange
        Voiture voiture1 = new Voiture();
        voiture1.setId(1L);
        voiture1.setModele("Model S");
        voiture1.setMarque("Tesla");
        voiture1.setAnnee(2020);
        voiture1.setType(TypeVoiture.SUV);
        voiture1.setChevauxFiscaux(10);
        voiture1.setPrix(80000.0);
        voiture1.setConsommation(15.0);
        voiture1.setCouleur("Red");

        Voiture voiture2 = new Voiture();
        voiture2.setId(2L);
        voiture2.setModele("Model 3");
        voiture2.setMarque("Tesla");
        voiture2.setAnnee(2021);
        voiture2.setType(TypeVoiture.BERLINE);
        voiture2.setChevauxFiscaux(8);
        voiture2.setPrix(50000.0);
        voiture2.setConsommation(10.0);
        voiture2.setCouleur("Blue");

        List<Voiture> voitures = Arrays.asList(voiture1, voiture2);
        when(voitureRepository.findByProprietaireNom("Doe")).thenReturn(voitures);

        // Act
        List<VoitureDTO> result = voitureService.recupererVoituresProprietaire("Doe");

        // Assert
        assertEquals(2, result.size());
        assertEquals(voiture1.getId(), result.get(0).getId());
        assertEquals(voiture1.getModele(), result.get(0).getModele());
        assertEquals(voiture1.getMarque(), result.get(0).getMarque());
        assertEquals(voiture1.getAnnee(), result.get(0).getAnnee());
        assertEquals(voiture1.getType(), result.get(0).getType());
        assertEquals(voiture1.getChevauxFiscaux(), result.get(0).getChevauxFiscaux());
        assertEquals(voiture1.getPrix(), result.get(0).getPrix());
        assertEquals(voiture1.getConsommation(), result.get(0).getConsommation());
        assertEquals(voiture1.getCouleur(), result.get(0).getCouleur());

        assertEquals(voiture2.getId(), result.get(1).getId());
        assertEquals(voiture2.getModele(), result.get(1).getModele());
        assertEquals(voiture2.getMarque(), result.get(1).getMarque());
        assertEquals(voiture2.getAnnee(), result.get(1).getAnnee());
        assertEquals(voiture2.getType(), result.get(1).getType());
        assertEquals(voiture2.getChevauxFiscaux(), result.get(1).getChevauxFiscaux());
        assertEquals(voiture2.getPrix(), result.get(1).getPrix());
        assertEquals(voiture2.getConsommation(), result.get(1).getConsommation());
        assertEquals(voiture2.getCouleur(), result.get(1).getCouleur());
    }

    @Test
    public void testGetVoituresWithNullList() {
        // Arrange
        when(voitureRepository.findByProprietaireNom("Doe")).thenReturn(null);

        // Act
        List<VoitureDTO> result = voitureService.recupererVoituresProprietaire("Doe");

        // Assert
        assertEquals(0, result.size());
    }

    @Test
    public void testGetVoituresByBrand() {
        Voiture voiture1 = new Voiture();
        voiture1.setId(1L);
        voiture1.setModele("Model S");
        voiture1.setMarque("Marque1");
        voiture1.setAnnee(2020);
        voiture1.setType(TypeVoiture.SUV);
        voiture1.setChevauxFiscaux(10);
        voiture1.setPrix(80000.0);
        voiture1.setConsommation(15.0);
        voiture1.setCouleur("Red");

        Voiture voiture2 = new Voiture();
        voiture2.setId(2L);
        voiture2.setModele("Model 3");
        voiture2.setMarque("Marque2");
        voiture2.setAnnee(2021);
        voiture2.setType(TypeVoiture.BERLINE);
        voiture2.setChevauxFiscaux(8);
        voiture2.setPrix(50000.0);
        voiture2.setConsommation(10.0);
        voiture2.setCouleur("Blue");

        // Arrange
        when(voitureRepository.findVoitureByMarque("Marque1")).thenReturn(List.of(voiture1));
        when(voitureRepository.findVoitureByMarque("Marque2")).thenReturn(List.of(voiture2));

        // Act
        List<VoitureDTO> marque1Voitures = voitureService.rechercherVoituresSelonMarques("Marque1");
        List<VoitureDTO> marque2Voitures = voitureService.rechercherVoituresSelonMarques("Marque2");

        // Assert
        assertEquals(1, marque1Voitures.size());
        assertEquals(voiture1.getId(), marque1Voitures.get(0).getId());
        assertEquals(voiture1.getModele(), marque1Voitures.get(0).getModele());
        assertEquals(voiture1.getMarque(), marque1Voitures.get(0).getMarque());
        assertEquals(voiture1.getAnnee(), marque1Voitures.get(0).getAnnee());
        assertEquals(voiture1.getType(), marque1Voitures.get(0).getType());
        assertEquals(voiture1.getChevauxFiscaux(), marque1Voitures.get(0).getChevauxFiscaux());
        assertEquals(voiture1.getPrix(), marque1Voitures.get(0).getPrix());
        assertEquals(voiture1.getConsommation(), marque1Voitures.get(0).getConsommation());
        assertEquals(voiture1.getCouleur(), marque1Voitures.get(0).getCouleur());

        assertEquals(1, marque2Voitures.size());
        assertEquals(voiture2.getId(), marque2Voitures.get(0).getId());
        assertEquals(voiture2.getModele(), marque2Voitures.get(0).getModele());
        assertEquals(voiture2.getMarque(), marque2Voitures.get(0).getMarque());
        assertEquals(voiture2.getAnnee(), marque2Voitures.get(0).getAnnee());
        assertEquals(voiture2.getType(), marque2Voitures.get(0).getType());
        assertEquals(voiture2.getChevauxFiscaux(), marque2Voitures.get(0).getChevauxFiscaux());
        assertEquals(voiture2.getPrix(), marque2Voitures.get(0).getPrix());
        assertEquals(voiture2.getConsommation(), marque2Voitures.get(0).getConsommation());
        assertEquals(voiture2.getCouleur(), marque2Voitures.get(0).getCouleur());
    }

    @Test
    public void testGetVoituresByType(){
        // Arrange
        Voiture voiture1 = new Voiture();
        voiture1.setId(1L);
        voiture1.setModele("Model S");
        voiture1.setMarque("Tesla");
        voiture1.setAnnee(2020);
        voiture1.setType(TypeVoiture.SUV);
        voiture1.setChevauxFiscaux(10);
        voiture1.setPrix(80000.0);
        voiture1.setConsommation(15.0);
        voiture1.setCouleur("Red");

        Voiture voiture2 = new Voiture();
        voiture2.setId(2L);
        voiture2.setModele("Model 3");
        voiture2.setMarque("Tesla");
        voiture2.setAnnee(2021);
        voiture2.setType(TypeVoiture.BERLINE);
        voiture2.setChevauxFiscaux(8);
        voiture2.setPrix(50000.0);
        voiture2.setConsommation(10.0);
        voiture2.setCouleur("Blue");

        // Arrange
        when(voitureRepository.findVoitureByType(TypeVoiture.SUV)).thenReturn(List.of(voiture1));
        when(voitureRepository.findVoitureByType(TypeVoiture.BERLINE)).thenReturn(List.of(voiture2));

        // Act
        List<VoitureDTO> suvs = voitureService.rechercherVoituresSelonType(TypeVoiture.SUV);
        List<VoitureDTO> berlines = voitureService.rechercherVoituresSelonType(TypeVoiture.BERLINE);

        // Assert
        assertEquals(1, suvs.size());
        assertEquals(voiture1.getId(), suvs.get(0).getId());
        assertEquals(voiture1.getModele(), suvs.get(0).getModele());
        assertEquals(voiture1.getMarque(), suvs.get(0).getMarque());
        assertEquals(voiture1.getAnnee(), suvs.get(0).getAnnee());
        assertEquals(voiture1.getType(), suvs.get(0).getType());
        assertEquals(voiture1.getChevauxFiscaux(), suvs.get(0).getChevauxFiscaux());
        assertEquals(voiture1.getPrix(), suvs.get(0).getPrix());
        assertEquals(voiture1.getConsommation(), suvs.get(0).getConsommation());
        assertEquals(voiture1.getCouleur(), suvs.get(0).getCouleur());

        assertEquals(1, berlines.size());
        assertEquals(voiture2.getId(), berlines.get(0).getId());
        assertEquals(voiture2.getModele(), berlines.get(0).getModele());
        assertEquals(voiture2.getMarque(), berlines.get(0).getMarque());
        assertEquals(voiture2.getAnnee(), berlines.get(0).getAnnee());
        assertEquals(voiture2.getType(), berlines.get(0).getType());
        assertEquals(voiture2.getChevauxFiscaux(), berlines.get(0).getChevauxFiscaux());
        assertEquals(voiture2.getPrix(), berlines.get(0).getPrix());
        assertEquals(voiture2.getConsommation(), berlines.get(0).getConsommation());
        assertEquals(voiture2.getCouleur(), berlines.get(0).getCouleur());
    }

    @Test
    public void testGetVoituresByPriceRange(){
        Voiture voiture1 = new Voiture();
        voiture1.setId(1L);
        voiture1.setModele("Model S");
        voiture1.setMarque("Marque1");
        voiture1.setAnnee(2020);
        voiture1.setType(TypeVoiture.SUV);
        voiture1.setChevauxFiscaux(10);
        voiture1.setPrix(80000.0);
        voiture1.setConsommation(15.0);
        voiture1.setCouleur("Red");

        Voiture voiture2 = new Voiture();
        voiture2.setId(2L);
        voiture2.setModele("Model 3");
        voiture2.setMarque("Marque2");
        voiture2.setAnnee(2021);
        voiture2.setType(TypeVoiture.BERLINE);
        voiture2.setChevauxFiscaux(8);
        voiture2.setPrix(50000.0);
        voiture2.setConsommation(10.0);
        voiture2.setCouleur("Blue");

        // Arrange
        when(voitureRepository.findVoitureByPrixBetween(0, 30000.0)).thenReturn(List.of());
        when(voitureRepository.findVoitureByPrixBetween(0, voiture2.getPrix())).thenReturn(List.of(voiture2));
        when(voitureRepository.findVoitureByPrixBetween(0, voiture1.getPrix())).thenReturn(List.of(voiture2, voiture1));
        when(voitureRepository.findVoitureByPrixBetween(70000.0, voiture1.getPrix())).thenReturn(List.of(voiture1));
        when(voitureRepository.findVoitureByPrixBetween(90000.0, 100000.0)).thenReturn(List.of());

        // Act
        List<VoitureDTO> zeroToBelow2 = voitureService.rechercherVoituresSelonPrixMinMax(0, 30000.0);
        List<VoitureDTO> below2ToAbove2Below1 = voitureService.rechercherVoituresSelonPrixMinMax(0, voiture2.getPrix());
        List<VoitureDTO> belowAllToV1 = voitureService.rechercherVoituresSelonPrixMinMax(0, voiture1.getPrix());
        List<VoitureDTO> above2Below1ToV1 = voitureService.rechercherVoituresSelonPrixMinMax(70000.0, voiture1.getPrix());
        List<VoitureDTO> above1ToAbove1 = voitureService.rechercherVoituresSelonPrixMinMax(90000.0, 100000.0);

        // Assert
        assertEquals(0, zeroToBelow2.size());

        assertEquals(1, below2ToAbove2Below1.size());
        assertEquals(voiture2.getPrix(), below2ToAbove2Below1.getFirst().getPrix());

        assertEquals(2, belowAllToV1.size());
        assertEquals(voiture2.getPrix(), belowAllToV1.getFirst().getPrix());
        assertEquals(voiture1.getPrix(), belowAllToV1.getLast().getPrix());

        assertEquals(1, above2Below1ToV1.size());
        assertEquals(voiture1.getPrix(), above2Below1ToV1.getLast().getPrix());

        assertEquals(0, above1ToAbove1.size());

    }


}
