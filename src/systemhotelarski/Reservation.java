package systemhotelarski;

import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import systemhotelarski.Client;
import systemhotelarski.Room;


@Entity
public class Reservation {

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.client);
        hash = 37 * hash + Objects.hashCode(this.room);
        hash = 37 * hash + Objects.hashCode(this.begining);
        hash = 37 * hash + Objects.hashCode(this.end);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Reservation other = (Reservation) obj;
        if (!Objects.equals(this.client, other.client)) {
            return false;
        }
        if (!Objects.equals(this.room, other.room)) {
            return false;
        }
        if (!Objects.equals(this.begining, other.begining)) {
            return false;
        }
        if (!Objects.equals(this.end, other.end)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Reservation{" + "client=" + client + ", room=" + room + ", begining=" + begining + ", end=" + end + '}';
    }
    private int id;
    private Client client;
    private Room room;
    private Date begining;
    private Date end;

    public Reservation(Client client, Date begining, Date end, Room room) {
        this.begining = begining;
        this.end = end;
        this.client = client;
        this.room = room;
    }

    public Reservation() {
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

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getBegining() {
        return begining;
    }

    public void setBegining(Date begining) {
        this.begining = begining;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }
}
