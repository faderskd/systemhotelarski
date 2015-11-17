/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemhotelarski;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author root
 */
public class ClientDaoJUnitTest {
    
    private static SessionFactory factory;
    
    public ClientDaoJUnitTest() {
    }
    
    @BeforeClass
    public static void setUpClass() { 
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        factory = new Configuration().configure().
                buildSessionFactory();
        
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String stringQuery = "DELETE FROM Client";
            Query query = session.createQuery(stringQuery);
            query.executeUpdate();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    
    }
  
    
    @After
    public void tearDown() {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String stringQuery = "DELETE FROM Client";
            Query query = session.createQuery(stringQuery);
            query.executeUpdate();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void addClientTest() {
        Session session = factory.openSession();
        Transaction tx = null;
        
        ClientDAO clientDao = new ClientDAO();
        
        Integer clientId = clientDao.addClient(
            "Daniel", "Faderski", "daniel@op.pl", 
            "1234", "Warszawa", "Polna", "500", "45", "123456789"
        );
        
        Client other = new Client(
            "Daniel", "Faderski", "daniel@op.pl", 
            "1234", "Warszawa", "Polna", "500", "45", "123456789"
        );
        
        try {
            tx = session.beginTransaction();
            Client client = (Client)session.get(Client.class, clientId);
            assertEquals(client, other);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    
    @Test
    public void getAllClientsTest() {
        Session session = factory.openSession();
        Transaction tx = null;
        
        ClientDAO clientDao = new ClientDAO();
        
        Integer clientId1 = clientDao.addClient(
            "Daniel", "Faderski", "daniel@op.pl", 
            "1234", "Warszawa", "Polna", "500", "45", "123456789"
        );
        
        Client other1 = new Client(
            "Daniel", "Faderski", "daniel@op.pl", 
            "1234", "Warszawa", "Polna", "500", "45", "123456789"
        );
        
        Integer clientId2 = clientDao.addClient(
                "Jan", "Kowalski",
                "daniel@op.pl", "1234", "Warszawa", "Polna",
                "500", "45", "123456789"
        );
 
        Client other2 = new Client(
            "Jan", "Kowalski", "daniel@op.pl", 
            "1234", "Warszawa", "Polna", "500", "45", "123456789"
        );        
        
        List<Client> testList = new ArrayList<Client>();
        testList.add(other1);
        testList.add(other2);
        
        List clients = clientDao.getAllClients();
        assertEquals(clients, testList);
    }
    
    @Test
    public void updateClientTest() {
        Session session = factory.openSession();
        Transaction tx = null;
        
        ClientDAO clientDao = new ClientDAO();
        Integer clientId = clientDao.addClient(
            "Daniel", "Faderski", "daniel@op.pl", 
            "1234", "Warszawa", "Polna", "500", "45", "123456789"
        );
        
        Client other = new Client(
            "Jan", "Kowalski", "daniel@op.pl", 
            "1234", "Warszawa", "Polna", "500", "45", "123456789"
        );
        
        clientDao.updateClient(clientId, "Jan", "Kowalski", "daniel@op.pl",
                "1234", "Warszawa", "Polna", "500", "45", "123456789");
        
        try {
            tx = session.beginTransaction();
            Client client = (Client)session.get(Client.class, clientId);
            assertEquals(client, other);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }    
    
    
    @Test
    public void deleteClientTest() {
        Session session = factory.openSession();
        Transaction tx = null;
        
        ClientDAO clientDao = new ClientDAO();
        Integer clientId = clientDao.addClient(
            "Daniel", "Faderski", "daniel@op.pl", 
            "1234", "Warszawa", "Polna", "500", "45", "123456789"
        );
        clientDao.deleteClient(clientId);
        
        try {
            tx = session.beginTransaction();
            Client client = (Client)session.get(Client.class, clientId);
            assertNull(client);
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
