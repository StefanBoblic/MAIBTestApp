package md.maib.app.maib.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;

import java.sql.Date;


@Entity
@Table(name = "Sciot")
public class Client implements Serializable {

    private int id;
    private String number;
    private double balance;
    private String currency;
    private Date last_oper_time;

    // for deserialisation
    public Client() {
    }

    @JsonCreator
    public Client(@JsonProperty("id") int id,@JsonProperty("number")String number,
                  @JsonProperty("balance") double balance,@JsonProperty("currency") String currency,
                  @JsonProperty("last_oper_time") Date last_oper_time) {
        this.id = id;
        this.number = number;
        this.balance = balance;
        this.currency = currency;
        this.last_oper_time = last_oper_time;
    }

    @Id
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "Number", nullable = false)
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }

    @Column(name = "Balance", nullable = false)
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Column(name = "Currency", nullable = false)
    public String getCurrency() {
        return currency;
    }
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Column(name = "Last_Operation_Time", nullable = false)
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
