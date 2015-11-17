package systemhotelarski;

import java.util.List; 
import java.util.Date;
import java.util.Iterator; 
 
import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import systemhotelarski.Room;


public class RoomDAO {
    private static SessionFactory factory;

    public int addRoom() {
        return 1;
    }
    
    public List getAllRooms() {
        return null;
    }
    
    public void updateRoom() {
        
    }
    
    public void deleteRoom() {
        
    }
}
