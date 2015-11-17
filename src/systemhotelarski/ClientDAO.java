package systemhotelarski;

import java.util.List; 
import java.util.Date;
import java.util.Iterator; 
 
import org.hibernate.HibernateException; 
import org.hibernate.Query;
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import systemhotelarski.Client;


public class ClientDAO {
    private static SessionFactory factory;
 
    public ClientDAO() {
        this.factory = new Configuration().configure().
                buildSessionFactory();  
    }
    
    public Integer addClient(String firstName, String lastName, String email,
            String password, String city, String street, String buildingNumber,
            String apartmentNumber, String telephoneNumber){
        Session session = factory.openSession();
        Transaction tx = null;
        Integer clientID = null;
        try {
            tx = session.beginTransaction();
            Client client = new Client(firstName, lastName, email, password,
            city, street, buildingNumber, apartmentNumber, telephoneNumber);
            clientID = (Integer) session.save(client);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return clientID;
    }
    
    public List getAllClients() {
        Session session = factory.openSession();
        Transaction tx = null;
        List clients = null;
        try {
            tx = session.beginTransaction();
            clients = session.createQuery("FROM Client").list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) 
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
            return clients;
        }
    }
    
    public void updateClient(Integer clientID, String firstName, String lastName, String email,
            String password, String city, String street, String buildingNumber,
            String apartmentNumber, String telephoneNumber) {
         
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Client client = (Client) session.get(Client.class, clientID);
            client.setApartmentNumber(apartmentNumber);
            client.setBuildingNumber(buildingNumber);
            client.setCity(city);
            client.setEmail(email);
            client.setFirstName(firstName);
            client.setLastName(lastName);
            client.setStreet(street);
            client.setTelephoneNumber(telephoneNumber);
            session.update(client);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) 
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    
    public void deleteClient(Integer clientID) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Client client = (Client) session.get(Client.class, clientID);
            session.delete(client);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) 
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
