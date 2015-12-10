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
            String apartmentNumber, String telephoneNumber, boolean isEmployee,
            boolean isAdmin, boolean isManager){
        Session session = factory.openSession();
        Transaction tx = null;
        Integer clientID = null;
        try {
            tx = session.beginTransaction();
            Client client = new Client(firstName, lastName, email, password,
            city, street, buildingNumber, apartmentNumber, telephoneNumber,
            isEmployee, isAdmin, isManager);
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

    public Client getClient(String firstName, String lastName) {
        
        Session session = factory.openSession();
        Transaction tx = null;
        List clients = null;
        try {
            tx = session.beginTransaction();
            String hsql = "FROM Client C WHERE C.firstName = :firstName" +
                           " AND C.lastName = :lastName";
            Query query = session.createQuery(hsql);
            query.setParameter("firstName", firstName);
            query.setParameter("lastName", lastName);
            clients = query.list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) 
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
            if (clients != null && clients.size() > 0)
                return (Client)clients.get(0);
            return null;
        }
    }


    public void updateClient(Integer clientID, String firstName, String lastName, String email,
            String password, String city, String street, String buildingNumber,
            String apartmentNumber, String telephoneNumber, boolean isEmployee,
            boolean isAdmin, boolean isManager) {
         
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
            client.setIsAdmin(isAdmin);
            client.setIsManager(isManager);
            client.setIsEmployee(isEmployee);
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

