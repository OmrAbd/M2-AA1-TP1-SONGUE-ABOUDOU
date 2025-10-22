package fac.luminy.m2.aa1.tp1.model.dto;

import fac.luminy.m2.aa1.tp1.model.entity.Proprietaire;
import lombok.Data;

import java.util.List;

@Data
public class VendeurDTO extends PersonneDTO{

    private List<VoitureDTO> voituresPossedees;

    public VendeurDTO(Proprietaire proprietaire) {
        super(proprietaire);
        this.voituresPossedees = proprietaire.getVoituresPossedees() == null ? null :
                proprietaire.getVoituresPossedees()
                        .stream()
                        .map(VoitureDTO::new)
                        .toList();
    }

}
