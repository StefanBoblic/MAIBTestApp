package md.maib.app.maib.service;

import md.maib.app.maib.entity.Client;
import md.maib.app.maib.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    public List<Client> checkSciot(String model) {
        return clientRepository.CheckSciot(model);
    }
}
