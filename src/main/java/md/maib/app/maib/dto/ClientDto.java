package md.maib.app.maib.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDto {
     int id;
     String number;
     double balance;
     String currency;
     Date last_oper_time;
}
