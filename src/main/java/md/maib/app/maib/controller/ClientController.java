package md.maib.app.maib.controller;

import md.maib.app.maib.entity.Client;
import md.maib.app.maib.exception.ResourceNotFoundException;
import md.maib.app.maib.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class ClientController {
    @Autowired
    private ClientRepository clientRepository;

    @Modifying
    @Query(value = "exec CheckSciot",nativeQuery = true)

    @GetMapping("/client")
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @GetMapping("/client/{id}")
    public ResponseEntity<Client> getClientByID(@PathVariable(value = "id") Long clientID)
            throws ResourceNotFoundException {
        Client client = clientRepository.findById(clientID)
                .orElseThrow(() -> new ResourceNotFoundException("Client not found for this id :: " + clientID));
        return ResponseEntity.ok().body(client);
    }

    @PostMapping("/Client")
    public Client createEmployee(@Valid @RequestBody Client client) {
        return clientRepository.save(client);
    }

    @PutMapping("/Client/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable(value = "id") Long clientID,
                                                   @Valid @RequestBody Client clientDetails) throws ResourceNotFoundException {
        Client client = clientRepository.findById(clientID)
                .orElseThrow(() -> new ResourceNotFoundException("Client not found for this id :: " + clientID));

        client.setNumber(clientDetails.getNumber());
        client.setBalance(clientDetails.getBalance());
        client.setCurrency(clientDetails.getCurrency());
        client.setLast_oper_time(clientDetails.getLast_oper_time());
        final Client updatedclient = clientRepository.save(client);
        return ResponseEntity.ok(updatedclient);
    }

    @DeleteMapping("/Client/{id}")
    public Map<String, Boolean> deleteClient(@PathVariable(value = "id") Long clientID)
            throws ResourceNotFoundException {
        Client client = clientRepository.findById(clientID)
                .orElseThrow(() -> new ResourceNotFoundException("Client not found for this id :: " + clientID));

        clientRepository.delete(client);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
