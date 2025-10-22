package fac.luminy.m2.aa1.tp1.model.dto;

import fac.luminy.m2.aa1.tp1.model.entity.Vendeur;
import lombok.Data;

import java.util.List;

@Data
public class VendeurDTO extends PersonneDTO{

    private List<VoitureDTO> voituresPossedees;

    public VendeurDTO(Vendeur vendeur) {
        super(vendeur);
        this.voituresPossedees = vendeur.getVoituresPossedees() == null ? null :
                vendeur.getVoituresPossedees()
                        .stream()
                        .map(VoitureDTO::new)
                        .toList();
    }

}
