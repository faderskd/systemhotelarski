package systemhotelarski;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import systemhotelarski.Client;

@Entity
public class Payment {
    private int id;
    private Client client;
    private double cost;

    public Payment(Client client, double cost) {
        this.client = client;
        this.cost = cost;
    }

    public Payment() {
    }

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
    
    @Override
    public boolean equals(Object o) {
        Payment p = (Payment)o;
        return this.cost == p.cost &&
               this.client.equals(p.client);
    } 

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.client);
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.cost) ^ (Double.doubleToLongBits(this.cost) >>> 32));
        return hash;
    }
}
