package fac.luminy.m2.aa1.tp1.model.dto;

import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class PersonneDTOTest {


    @Test
    public void testPersonneDTOConstructor() {
        // Arrange
        Personne personne = new Personne();
        personne.setId(1L);
        personne.setNom("Doe");
        personne.setPrenom("John");
        personne.setAdresse("123 Main St");
        personne.setCodePostal("12345");
        personne.setEmail("john.doe@example.com");
        personne.setVoituresPossedees(Collections.emptyList());
        personne.setVoituresLouees(Collections.emptyList());

        // Act
        PersonneDTO personneDTO = new PersonneDTO(personne);

        // Assert
        assertEquals(personne.getId(), personneDTO.getId());
        assertEquals(personne.getNom(), personneDTO.getNom());
        assertEquals(personne.getPrenom(), personneDTO.getPrenom());
        assertEquals(personne.getAdresse(), personneDTO.getAdresse());
        assertEquals(personne.getCodePostal(), personneDTO.getCodePostal());
        assertEquals(personne.getEmail(), personneDTO.getEmail());
        assertEquals(personne.getVoituresPossedees().size(), personneDTO.getVoituresPossedees().size());
        assertEquals(personne.getVoituresLouees().size(), personneDTO.getVoituresLouees().size());
    }

    @Test
    public void testPersonneDTOConstructorWithNullValues() {
        // Arrange
        Personne personne = new Personne();
        personne.setId(null);
        personne.setNom(null);
        personne.setPrenom(null);
        personne.setAdresse(null);
        personne.setCodePostal(null);
        personne.setEmail(null);
        personne.setVoituresPossedees(null);
        personne.setVoituresLouees(null);

        // Act
        PersonneDTO personneDTO = new PersonneDTO(personne);

        // Assert
        assertNull(personneDTO.getId());
        assertNull(personneDTO.getNom());
        assertNull(personneDTO.getPrenom());
        assertNull(personneDTO.getAdresse());
        assertNull(personneDTO.getCodePostal());
        assertNull(personneDTO.getEmail());
        assertNull(personneDTO.getVoituresPossedees());
        assertNull(personneDTO.getVoituresLouees());
    }

    @Test
    public void testPersonneDTOConstructorWithExtremeValues() {
        // Arrange
        Personne personne = new Personne();
        personne.setId(Long.MAX_VALUE);
        personne.setNom("A".repeat(255));
        personne.setPrenom("B".repeat(255));
        personne.setAdresse("C".repeat(255));
        personne.setCodePostal("D".repeat(10));
        personne.setEmail("E".repeat(255));
        personne.setVoituresPossedees(Collections.emptyList());
        personne.setVoituresLouees(Collections.emptyList());

        // Act
        PersonneDTO personneDTO = new PersonneDTO(personne);

        // Assert
        assertEquals(personne.getId(), personneDTO.getId());
        assertEquals(personne.getNom(), personneDTO.getNom());
        assertEquals(personne.getPrenom(), personneDTO.getPrenom());
        assertEquals(personne.getAdresse(), personneDTO.getAdresse());
        assertEquals(personne.getCodePostal(), personneDTO.getCodePostal());
        assertEquals(personne.getEmail(), personneDTO.getEmail());
        assertEquals(personne.getVoituresPossedees().size(), personneDTO.getVoituresPossedees().size());
    }
    }
