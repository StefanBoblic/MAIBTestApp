package md.maib.app.maib.controller;

import md.maib.app.maib.dto.ClientDto;
import md.maib.app.maib.entity.Client;
import md.maib.app.maib.exception.ResourceNotFoundException;
import md.maib.app.maib.repository.ClientRepository;
import md.maib.app.maib.service.MapService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private MapService mapService;


    @GetMapping("/client")
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

   // @GetMapping("/client/procedure")
    //public List<Client> checkSciot(Client client) {
     //   return clientRepository.CheckSciot();
    //}

    @GetMapping("/clientDTO")
    @ResponseBody
    public List<ClientDto> getAllUsers() {
        List <ClientDto> clientDto = mapService.getAllUsers();
            return clientDto;
    }

    @GetMapping("/client/{id}")
    public ResponseEntity<Client> getClientByID(@PathVariable(value = "id") Integer clientID)
            throws ResourceNotFoundException {
        Client client = clientRepository.findById((clientID))
                .orElseThrow(() -> new ResourceNotFoundException("Client not found for this id :: " + clientID));
        return ResponseEntity.ok().body(client);
    }

    @PostMapping("/Client")
    public Client createClient(@Valid @RequestBody Client client) {
        return clientRepository.save(client);
    }

    @PutMapping("/Client/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable(value = "id") Integer clientID,
                                                   @Valid @RequestBody Client clientDetails) throws ResourceNotFoundException {
        Client client = clientRepository.findById((clientID))
                .orElseThrow(() -> new ResourceNotFoundException("Client not found for this id :: " + clientID));

        client.setNumber(clientDetails.getNumber());
        client.setBalance(clientDetails.getBalance());
        client.setCurrency(clientDetails.getCurrency());
        client.setLast_oper_time(clientDetails.getLast_oper_time());
        final Client updatedclient = clientRepository.save(client);
        return ResponseEntity.ok(updatedclient);
    }

    @DeleteMapping("/Client/{id}")
    public Map<String, Boolean> deleteClient(@PathVariable(value = "id") Integer clientID)
            throws ResourceNotFoundException {
        Client client = clientRepository.findById((clientID))
                .orElseThrow(() -> new ResourceNotFoundException("Client not found for this id :: " + clientID));

        clientRepository.delete(client);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
