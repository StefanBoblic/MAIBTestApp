package md.maib.app.maib.repository;


import md.maib.app.maib.dto.ClientDto;
import md.maib.app.maib.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
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
    public List<Client> CheckSciot() {
        return namedParameterJdbcTemplate.query("exec CheckSciot", new RowMapper<Client>() {
            @Override
            public Client mapRow(ResultSet resultSet, int i) throws SQLException {
                Client client = new Client();
                client.setId(resultSet.getInt("ID"));
                client.setNumber(resultSet.getString("Number"));
                client.setBalance(resultSet.getDouble("Balance"));
                client.setCurrency(resultSet.getString("Currency"));
                client.setLast_oper_time(resultSet.getDate("last_operation_time"));
                return client;
            }
        });
    }
}
