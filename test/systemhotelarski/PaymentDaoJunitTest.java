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
public class PaymentDaoJunitTest {
    
    private static SessionFactory factory;
    
    public PaymentDaoJunitTest() {
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
            String stringQuery = "DELETE FROM Payment";
            Query query = session.createQuery(stringQuery);
            query.executeUpdate();
            stringQuery = "DELETE FROM Client";
            query = session.createQuery(stringQuery);
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
            String stringQuery = "DELETE FROM Payment";
            Query query = session.createQuery(stringQuery);
            query.executeUpdate();
            stringQuery = "DELETE FROM Client";
            query = session.createQuery(stringQuery);
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
    @Test
    public void addPaymentTest() {
        Session session = factory.openSession();
        Transaction tx = null;
        
        PaymentDAO paymentDao = new PaymentDAO();
        
        Client client1 = new Client(
            "Daniel", "Faderski", "daniel@op.pl", 
            "1234", "Warszawa", "Polna", "500", "45", "123456789"
        );
        
        Client client2 = new Client(
            "Daniel", "Faderski", "daniel@op.pl", 
            "1234", "Warszawa", "Polna", "500", "45", "123456789"
        );
        
        Payment other = new Payment(client2, 100);
       
        Integer paymentId = paymentDao.addPayment(client1, 100);
        
        
        try {
            tx = session.beginTransaction();
            Payment payment = (Payment)session.get(Payment.class, paymentId);
            assertEquals(payment, other);
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
    public void getAllPaymentsTest() {
        Session session = factory.openSession();
        Transaction tx = null;
        
        
        Client client1 = new Client(
            "Daniel", "Faderski", "daniel@op.pl", 
            "1234", "Warszawa", "Polna", "500", "45", "123456789"
        );
        
        Client client2 = new Client(
            "Jan", "Kowalski", "daniel@op.pl", 
            "1234", "Warszawa", "Polna", "500", "45", "123456789"
        );
        
        Payment other1 = new Payment(client1, 100);
        Payment other2 = new Payment(client2, 100);
       
        List<Payment> testList = new ArrayList<Payment>();
        testList.add(other1);
        testList.add(other2);
        
        
        Client client3 = new Client(
            "Daniel", "Faderski", "daniel@op.pl", 
            "1234", "Warszawa", "Polna", "500", "45", "123456789"
        );
        
        Client client4 = new Client(
            "Jan", "Kowalski", "daniel@op.pl", 
            "1234", "Warszawa", "Polna", "500", "45", "123456789"
        );
        
        Payment payment1 = new Payment(client3, 100);
        Payment payment2 = new Payment(client4, 100);
        
        try {
            tx = session.beginTransaction();
            
            session.save(client3);
            session.save(client4);
            session.save(payment1);
            session.save(payment2);
       
            tx.commit();
            
            tx = session.beginTransaction();

            PaymentDAO paymentDao = new PaymentDAO();
            List payments = paymentDao.getAllPayments();
            assertEquals(payments, testList);
            
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
    public void updatePaymentTest() {
        Session session = factory.openSession();
        Transaction tx = null;
        
        PaymentDAO paymentDao = new PaymentDAO();
        
        Client client = new Client(
            "Jan", "Kowalski", "daniel@op.pl", 
            "1234", "Warszawa", "Polna", "500", "45", "123456789"
        );
        
        Payment payment = new Payment(client, 200);
        
        Integer paymentId = paymentDao.addPayment(client, 100);

        paymentDao.updatePayment(paymentId, client, 200);
        
        try {
            tx = session.beginTransaction();
            Payment updated = (Payment)session.get(Payment.class, paymentId);
            assertEquals(payment, updated);
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
    public void deletePaymentTest() {
        Session session = factory.openSession();
        Transaction tx = null;
        
        PaymentDAO paymentDao = new PaymentDAO();
        
        Client client = new Client(
            "Jan", "Kowalski", "daniel@op.pl", 
            "1234", "Warszawa", "Polna", "500", "45", "123456789"
        );
        
        Payment payment = new Payment(client, 100);
        
        Integer paymentId = paymentDao.addPayment(client, 100);
        
        paymentDao.deletePayment(paymentId);
        
        try {
            tx = session.beginTransaction();
            Payment deleted = (Payment)session.get(Payment.class, paymentId);
            assertEquals(deleted, null);
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
