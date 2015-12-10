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

import systemhotelarski.Offer;


public class OfferDAO {
    private static SessionFactory factory;

    public OfferDAO() {
        this.factory = new Configuration().configure().
                buildSessionFactory(); 
    }
    
    public int addOffer(String description, int numberOfPeople, String image,
            double price, Room room){
        Session session = factory.openSession();
        Transaction tx = null;
        Integer offerID = null;
        try {
            tx = session.beginTransaction();
            Offer offer = new Offer(description, numberOfPeople, image, price,
                    room);
            session.save(room);
            offerID = (Integer) session.save(offer);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return offerID;
    }
    
    public List getAllOffers() {
        Session session = factory.openSession();
        Transaction tx = null;
        List offers = null;
        try {
            tx = session.beginTransaction();
            offers = session.createQuery("FROM offer").list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) 
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
            return offers;
        }
    }
    
    public Offer getOffer(Room room) {
        
        Session session = factory.openSession();
        Transaction tx = null;
        List offers = null;
        try {
            tx = session.beginTransaction();
            String hsql = "FROM Offer O WHERE O.room = :room";
            Query query = session.createQuery(hsql);
            query.setParameter("room", room);
            offers = query.list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) 
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
            if (offers != null && offers.size() > 0)
                return (Offer)offers.get(0);
            return null;
        }
    }
    
    
    public void updateOffer(Integer offerID, String description,
            int numberOfPeople, String image, double price, Room room) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Offer offer = (Offer) session.get(Offer.class, offerID);
            offer.setDescription(description);
            offer.setNumberOfPeople(numberOfPeople);
            offer.setImage(image);
            offer.setPrice(price);
            offer.setRoom(room);
            
            session.update(offer);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) 
                e.printStackTrace();
        } finally {
            session.close();
        }
    }
    
    public void deleteOffer(Integer offerID) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Offer offer = (Offer) session.get(Offer.class, offerID);
            session.delete(offer);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) 
                e.printStackTrace();
        } finally {
            session.close();
        }
    }
}