package systemhotelarski;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import systemhotelarski.Client;
import systemhotelarski.Room;


@Entity
public class Reservation {
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
