package md.maib.app.maib.repository;

import md.maib.app.maib.dto.ClientDto;
import md.maib.app.maib.entity.Client;

import java.util.List;

public interface ClientRepositoryDB {
    List<ClientDto> CheckSciot();
}
