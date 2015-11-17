package systemhotelarski;

import java.util.List; 
import java.util.Date;
import java.util.Iterator; 
 
import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import systemhotelarski.Reservation;


public class ReservationDAO {
    private static SessionFactory factory;

    public int addReservation() {
        return 1;
    }
    
    public List getAllReservations() {
        return null;
    }
    
    public void updateReservation() {
        
    }
    
    public void deleteReservation() {
        
    }
}
