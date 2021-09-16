package md.maib.app.maib.service;

import md.maib.app.maib.dto.ClientDto;
import md.maib.app.maib.entity.Client;
import md.maib.app.maib.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MapService {

    @Autowired
    private ClientRepository clientRepository;

    public List<ClientDto> getAllUsers() {
        return ((List<Client>) clientRepository
                .findAll())
                .stream()
                .map(this::convertToClientDto)
                .collect(Collectors.toList());
    }

    private ClientDto convertToClientDto(Client client) {
        ClientDto clientDto = new ClientDto();
        clientDto.setId(client.getId());
        clientDto.setNumber(client.getNumber());
        clientDto.setBalance(client.getBalance());
        clientDto.setCurrency(client.getCurrency());
        clientDto.setLast_oper_time(client.getLast_oper_time());
        return clientDto;
    }
}
