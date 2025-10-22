package fac.luminy.m2.aa1.tp1.model.dto;

import fac.luminy.m2.aa1.tp1.model.entity.Client;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class ClientDTO extends PersonneDTO {

    private List<LocationDTO> locationEnTantQueClient;

    public ClientDTO(Client client) {
        super(client);
        this.locationEnTantQueClient = client.getLocationsEnTantQueClient() == null ? null :
                client.getLocationsEnTantQueClient()
                        .stream()
                        .map(LocationDTO::new)
                        .collect(Collectors.toList());
    }

}
