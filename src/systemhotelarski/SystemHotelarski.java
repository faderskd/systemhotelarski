package systemhotelarski;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Date;
import systemhotelarski.Client;
import systemhotelarski.Room;
import systemhotelarski.Reservation;
import systemhotelarski.Payment;
import systemhotelarski.Offer;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SystemHotelarski {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().
                buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        Client client = new Client("Daniel", "Faderski", "daniel@op.pl", 
        "1234", "Warszawa", "Polna", "500", "45", "123456789");
        Room room = new Room("501");
        Date begining = new Date(2015, 12, 23);
        Date end = new Date(2015, 12, 25);
        Reservation reservation = new Reservation(client, begining, end, room);
        Payment payment = new Payment(client, 25.5);
        Offer offer = new Offer("jakas fajna oferta", 2,
                "/home/asfsdaf/asdf.jpg", 2.5, room);
        
        
        session.save(client);
        session.save(room);
        session.save(reservation);
        session.save(payment);
        session.save(offer);
                
        session.getTransaction().commit();
        
        session.close();
    }
    
}
