package fac.luminy.m2.aa1.tp1.model.dto;

import fac.luminy.m2.aa1.tp1.model.entity.Proprietaire;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class ProprietaireDTO extends PersonneDTO{

    private LocalDate startDate;
    private List<VoitureDTO> voituresPossedees;

    public ProprietaireDTO(Proprietaire proprietaire) {
        super(proprietaire);
        this.startDate = proprietaire.getStartDate();
        this.voituresPossedees = proprietaire.getVoituresPossedees() == null ? null :
                proprietaire.getVoituresPossedees()
                        .stream()
                        .map(VoitureDTO::new)
                        .toList();
    }

}
