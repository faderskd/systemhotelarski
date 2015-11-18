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


public class OfferDaoJUnitTest {
    
    private static SessionFactory factory;
    
    public OfferDaoJUnitTest() {
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
            String stringQuery = "DELETE FROM Offer";
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
            String stringQuery = "DELETE FROM Offer";
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

    
    @Test
    public void addOfferTest() {
        Session session = factory.openSession();
        Transaction tx = null;
        tx = session.beginTransaction();
        
        OfferDAO offerDao = new OfferDAO();
        Room room = new Room("51a");
        
        session.save(room);
        Integer offerId = offerDao.addOffer("super oferta", 4, "/home/cos.jpg",
                25.0, room);
        
        Offer offer1 = new Offer("super oferta", 4, "/home/cos.jpg", 25.0,
                room);
        
        try {
            tx = session.beginTransaction();
            Offer offer = (Offer)session.get(Offer.class, offerId);
            assertEquals(offer1, offer);
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
    public void getAllOffersTest() {
        Session session = factory.openSession();
        Transaction tx = null;
        tx = session.beginTransaction();

        Room room = new Room("51a");
        
        session.save(room);
        
        OfferDAO offerDao = new OfferDAO();
        
        Integer offerId = offerDao.addOffer("super oferta", 4, "/home/cos.jpg",
                25.0, room);
        
        Offer offer1 = new Offer("super oferta", 4, "/home/cos.jpg", 25.0,
                room);
        
        Integer offer2Id = offerDao.addOffer("super oferta2", 4, "/home/cos.jpg",
                25.0, room);
        
        Offer offer2 = new Offer("super oferta2", 4, "/home/cos.jpg", 25.0,
                room);
        
        

        List<Offer> testList = new ArrayList<Offer>();
        testList.add(offer1);
        testList.add(offer2);
        
        try {
            tx = session.beginTransaction();
            List offers = offerDao.getAllOffers();
            assertEquals(offers, testList);
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
    public void updateOfferTest() {
        Session session = factory.openSession();
        Transaction tx = null;

        Room room = new Room("51a");
        
        OfferDAO offerDao = new OfferDAO();

        Integer offerId = offerDao.addOffer("super oferta2", 4, "/home/cos.jpg",
                25.0, room);
        
        Offer offer1 = new Offer("super oferta", 4, "/home/cos.jpg", 25.0,
                room);
        
        
        offerDao.updateOffer(offerId, "super oferta", 4, "/home/cos.jpg", 25.0,
                room);
        
        try {
            tx = session.beginTransaction();
            Offer offer = (Offer)session.get(Offer.class, offerId);
            assertEquals(offer1, offer);
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
    public void deleteOfferTest() {
        Session session = factory.openSession();
        Transaction tx = null;
        
        OfferDAO offerDao = new OfferDAO();
        
        Room room = new Room("51a");
        
        Offer offer = new Offer("super oferta", 4, "/home/cos.jpg", 25.0,
                room);
        
        Integer offerId = offerDao.addOffer("super oferta", 4, "/home/cos.jpg",
                25.0, room);
        
        offerDao.deleteOffer(offerId);
        
        try {
            tx = session.beginTransaction();
            Offer deleted = (Offer)session.get(Offer.class, offerId);
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