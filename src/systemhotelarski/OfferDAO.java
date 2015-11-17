package systemhotelarski;

import java.util.List; 
import java.util.Date;
import java.util.Iterator; 
 
import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import systemhotelarski.Offer;


public class OfferDAO {
    private static SessionFactory factory;
    
    public int addOffer(){
        return 1;
    }
    
    public List getAllOffers() {
        return null;
    }
    
    public void updateOffer() {
        
    }
    
    public void deleteOffer() {
        
    }
}
