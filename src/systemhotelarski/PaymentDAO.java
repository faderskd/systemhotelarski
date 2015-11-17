package systemhotelarski;

import java.util.List; 
import java.util.Date;
import java.util.Iterator; 
 
import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import systemhotelarski.Payment;


public class PaymentDAO {
    private static SessionFactory factory;

    public int addPayment() {
        return 1;
    }
    
    public List getAllPayments() {
        return null;
    }
    
    public void updatePayment() {
        
    }
    
    public void deletePayment() {
        
    }
}
