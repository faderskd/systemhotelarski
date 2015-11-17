package systemhotelarski;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import systemhotelarski.Room;

@Entity
public class Offer {
    private int id;
    private String description;
    private int numberOfPeople;
    private String image;
    private double price;
    private Room room;

    public Offer(String description, int numberOfPeople, String image,
            double price, Room room) {
        this.description = description;
        this.numberOfPeople = numberOfPeople;
        this.image = image;
        this.price = price;
        this.room = room;
    }

    public Offer() {
    }

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
    
}
