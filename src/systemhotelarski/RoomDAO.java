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

import systemhotelarski.Room;


public class RoomDAO {
    private static SessionFactory factory;
    
    public RoomDAO() {
        this.factory = new Configuration().configure().
                buildSessionFactory(); 
    }

    public int addRoom(String number) {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer roomID = null;
        try {
            tx = session.beginTransaction();
            Room room = new Room(number);
            roomID = (Integer) session.save(room);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return roomID;
    }
    
    public List getAllRooms() {
        Session session = factory.openSession();
        Transaction tx = null;
        List rooms = null;
        try {
            tx = session.beginTransaction();
            rooms = session.createQuery("FROM Room").list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) 
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
            return rooms;
        }
    }
    
    
    public Room getRoom(String number) {
        
        Session session = factory.openSession();
        Transaction tx = null;
        List rooms = null;
        try {
            tx = session.beginTransaction();
            String hsql = "FROM Room R WHERE R.number = :number";
            Query query = session.createQuery(hsql);
            query.setParameter("number", number);
            rooms = query.list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) 
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
            if (rooms != null && rooms.size() > 0)
                return (Room)rooms.get(0);
            return null;
        }
    }
    
    
    public void updateRoom(Integer RoomID, String number) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Room room = (Room) session.get(Room.class, RoomID);
            room.setNumber(number);
            session.update(room);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) 
                e.printStackTrace();
        } finally {
            session.close();
        }
    }
    
    public void deleteRoom(Integer RoomID) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Room room = (Room) session.get(Room.class, RoomID);
            session.delete(room);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) 
                e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
