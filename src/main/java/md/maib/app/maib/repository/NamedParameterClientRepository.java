package md.maib.app.maib.repository;


import md.maib.app.maib.dto.ClientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class NamedParameterClientRepository implements ClientRepositoryDB{

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<ClientDto> CheckSciot() {
        return namedParameterJdbcTemplate.query("exec CheckSciot", new RowMapper<ClientDto>() {
            @Override
            public ClientDto mapRow(ResultSet resultSet, int i) throws SQLException {
                ClientDto clientDto = new ClientDto();
                clientDto.setId(resultSet.getInt("ID"));
                clientDto.setNumber(resultSet.getString("Number"));
                clientDto.setBalance(resultSet.getDouble("Balance"));
                clientDto.setCurrency(resultSet.getString("Currency"));
                clientDto.setLast_oper_time(resultSet.getDate("last_operation_time"));
                return clientDto;
            }
        });
    }
}
