package systemhotelarski;

import com.sun.org.apache.xpath.internal.operations.Equals;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Client {
    private int id;
    private String apartmentNumber;
    private String buildingNumber;
    private String city;
    private String email;
    private String firstName;
    private String lastName;
    private String street;
    private String telephoneNumber;
    private String password;
    private boolean isEmployee;
    private boolean isAdmin;
    private boolean isManager;

    public Client(String firstName, String lastName, String email,
            String password, String city, String street, String buildingNumber,
            String apartmentNumber, String telephoneNumber, boolean isEmployee,
            boolean isAdmin, boolean isManager) {
        this.apartmentNumber = apartmentNumber;
        this.buildingNumber = buildingNumber;
        this.city = city;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.telephoneNumber = telephoneNumber;
        this.isEmployee = isEmployee;
    }

    public Client() {
        
    }
    
    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public boolean getIsEmployee() {
        return this.isEmployee;
    }
    public void setIsEmployee(boolean isEmployee) {
        this.isEmployee = isEmployee;
    }

    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public boolean isIsManager() {
        return isManager;
    }

    public void setIsManager(boolean isManager) {
        this.isManager = isManager;
    }
    
    @Override
    public boolean equals(Object o ) {
        Client c = (Client)o;
        boolean equal = c.getApartmentNumber().equals(this.apartmentNumber) &&
                c.getBuildingNumber().equals(this.buildingNumber) &&
                c.getCity().equals(this.city ) &&
                c.getEmail().equals(this.email) &&
                c.getFirstName().equals(this.firstName) &&
                c.getLastName().equals(this.lastName) &&
                c.getStreet().equals(this.street) &&
                c.getTelephoneNumber().equals(this.telephoneNumber);
        return equal;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.apartmentNumber);
        hash = 29 * hash + Objects.hashCode(this.buildingNumber);
        hash = 29 * hash + Objects.hashCode(this.city);
        hash = 29 * hash + Objects.hashCode(this.email);
        hash = 29 * hash + Objects.hashCode(this.firstName);
        hash = 29 * hash + Objects.hashCode(this.lastName);
        hash = 29 * hash + Objects.hashCode(this.street);
        hash = 29 * hash + Objects.hashCode(this.telephoneNumber);
        return hash;
    }
}

