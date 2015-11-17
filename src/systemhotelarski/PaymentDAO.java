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

    public PaymentDAO() {
        this.factory = new Configuration().configure().
                buildSessionFactory(); 
    }

    public int addPayment(Client client, double cost) {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer paymentID = null;
        try {
            tx = session.beginTransaction();
            Payment payment = new Payment(client, cost);
            session.save(client);
            paymentID = (Integer) session.save(payment);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return paymentID;
    }
    
    public List getAllPayments() {
        Session session = factory.openSession();
        Transaction tx = null;
        List payments = null;
        try {
            tx = session.beginTransaction();
            payments = session.createQuery("FROM Payment").list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) 
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
            return payments;
        }
    }
    
    public void updatePayment(Integer paymentID, Client client, double cost) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Payment payment = (Payment) session.get(Payment.class, paymentID);
            payment.setClient(client);
            payment.setCost(cost);
            
            session.update(payment);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) 
                e.printStackTrace();
        } finally {
            session.close();
        }
    }
    
    public void deletePayment(Integer paymentID) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Payment payment = (Payment) session.get(Payment.class, paymentID);
            session.delete(payment);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) 
                e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
