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


public class RoomDaoJUnitTest {
    
    private static SessionFactory factory;
    
    public RoomDaoJUnitTest() {
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
            String stringQuery = "DELETE FROM Room";
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
            String stringQuery = "DELETE FROM Room";
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
    public void addRoomTest() {
        Session session = factory.openSession();
        Transaction tx = null;
        
        RoomDAO roomDao = new RoomDAO();
        Integer roomId = roomDao.addRoom("51a");
        
        Room other = new Room("51a");
        
        try {
            tx = session.beginTransaction();
            Room room = (Room)session.get(Room.class, roomId);
            assertEquals(room, other);
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
    public void getAllRoomsTest() {
        Session session = factory.openSession();
        Transaction tx = null;
        
        RoomDAO roomDao = new RoomDAO();
        
        Integer roomId1 = roomDao.addRoom("51a");
        
        Room other1 = new Room("51a");
        
        Integer roomId2 = roomDao.addRoom("101");
        Room other2 = new Room("101");

        List<Room> testList = new ArrayList<Room>();
        testList.add(other1);
        testList.add(other2);
        
        try {
            tx = session.beginTransaction();
            List rooms = roomDao.getAllRooms();
            assertEquals(rooms, testList);
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
    public void updateClientTest() {
        Session session = factory.openSession();
        Transaction tx = null;
        
        RoomDAO roomDao = new RoomDAO();
        Integer roomId = roomDao.addRoom("51b");
        
        Room other = new Room("51a");
        
        roomDao.updateRoom(roomId, "51a");
        
        try {
            tx = session.beginTransaction();
            Room room = (Room)session.get(Room.class, roomId);
            assertEquals(room, other);
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
    public void deleteRoomTest() {
        Session session = factory.openSession();
        Transaction tx = null;
        
        RoomDAO roomDao = new RoomDAO();
        Integer roomId = roomDao.addRoom("51a");
        roomDao.deleteRoom(roomId);
        
        try {
            tx = session.beginTransaction();
            Room room = (Room)session.get(Room.class, roomId);
            assertNull(room);
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