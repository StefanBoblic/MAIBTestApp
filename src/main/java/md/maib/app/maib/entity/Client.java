package md.maib.app.maib.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.models.auth.In;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "Sciot")
public class Client {

    private int id;
    private int number;
    private int balance;
    private String currency;
    private Date last_oper_time;

    // for deserialisation
    public Client() {
    }

    @JsonCreator
    public Client(@JsonProperty("id") int id,@JsonProperty("number")int number,
                  @JsonProperty("balance") int balance,@JsonProperty("currency") String currency,
                  @JsonProperty("last_oper_time") Date last_oper_time) {
        this.id = id;
        this.number = number;
        this.balance = balance;
        this.currency = currency;
        this.last_oper_time = last_oper_time;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "Number", nullable = false)
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }

    @Column(name = "Balance", nullable = false)
    public int getBalance() {
        return balance;
    }
    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Column(name = "Currency", nullable = false)
    public String getCurrency() {
        return currency;
    }
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Column(name = "LastOperationTime", nullable = false)
    public Date getLast_oper_time() {
        return last_oper_time;
    }
    public void setLast_oper_time(Date last_oper_time) {
        this.last_oper_time = last_oper_time;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", number=" + number + ", balance=" + balance + ", currency=" + currency + ", last_operation_time=" + last_oper_time
                + "]";
    }
}
