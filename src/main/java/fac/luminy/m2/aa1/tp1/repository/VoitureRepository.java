package fac.luminy.m2.aa1.tp1.repository;

import fac.luminy.m2.aa1.tp1.model.TypeVoiture;
import fac.luminy.m2.aa1.tp1.model.entity.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VoitureRepository extends JpaRepository<Voiture, Long> {

    List<Voiture> findByProprietaireNom(@Param("nom") String nom);

    List<Voiture> findVoitureByMarque(@Param("marque") String marque);

    List<Voiture> findVoitureByType(@Param("type") TypeVoiture type);

    List<Voiture> findVoitureByPrixBetween(double prixAfter, double prixBefore);
}
