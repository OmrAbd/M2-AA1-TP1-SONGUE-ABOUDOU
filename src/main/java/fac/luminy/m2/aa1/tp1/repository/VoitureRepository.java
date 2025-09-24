package fac.luminy.m2.aa1.tp1.repository;

import fac.luminy.m2.aa1.tp1.model.TypeVoiture;
import fac.luminy.m2.aa1.tp1.model.entity.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VoitureRepository extends JpaRepository<Voiture, Long> {

    List<Voiture> findByProprietaireNom(@Param("nom") String nom);

    @Query("""
    SELECT v FROM VOITURE v
    WHERE (:marque IS NULL OR v.marque = :marque)
      AND v.prix >= :prixAfter
      AND v.prix <= :prixBefore
""")List<Voiture> findVoitureByCriteria(@Param("marque") String marque,
                                        @Param("prixAfter") double prixAfter,
                                        @Param("prixBefore") double prixBefore);
}
