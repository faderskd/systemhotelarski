/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObslugaRezerwacji;

import java.util.ArrayList;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import systemhotelarski.Client;
import systemhotelarski.Reservation;
import systemhotelarski.Room;

/**
 *
 * @author monum_000
 */
public class ObslugaRezerwacjiTest {
    
    public ObslugaRezerwacjiTest() {
    }
    
    
    /**
     * Test of edytujRezerwacje method, of class ObslugaRezerwacji.
     */
    @Test
    public void testEdytujRezerwacje() {
        System.out.println("edytujRezerwacje");
        Client Klient = new Client("Daniel", "Faderski", "daniel@op.pl", 
        "1234", "Warszawa", "Polna", "500", "45", "123456789",false,false,false);
        Room room = new Room("123");
        Date Begin = new Date(2015,12,12);
        Date end = new Date(2015,12,16);
        ObslugaRezerwacji instance = new ObslugaRezerwacji();
        boolean expResult = true;
        Reservation resOld = new Reservation(Klient, Begin,end,room);
        Room nowy = new Room("456");
        Reservation resNew = new Reservation(Klient, Begin, end, nowy);
        boolean zr = instance.zrobRezerwacje(Klient, room, Begin, end);
        
        boolean result = instance.edytujRezerwacje(resOld, resNew);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of kasujRezerwacje method, of class ObslugaRezerwacji.
     */
    @Test
    public void testKasujRezerwacje() {
        Client Klient = new Client("Daniel", "Faderski", "daniel@op.pl", 
        "1234", "Warszawa", "Polna", "500", "45", "123456789",false,false,false);
        Room room = new Room("123");
        Date Begin = new Date(2015,12,12);
        Date end = new Date(2015,12,16);
        ObslugaRezerwacji instance = new ObslugaRezerwacji();
        boolean expResult = true;
        Reservation resOld = new Reservation(Klient, Begin,end,room);

        boolean zr = instance.zrobRezerwacje(Klient, room, Begin, end);
        boolean result = instance.kasujRezerwacje(resOld);
        assertEquals(expResult, result);
    }

    /**
     * Test of zrobRezerwacje method, of class ObslugaRezerwacji.
     */
    @Test
    public void testZrobRezerwacje() {
        System.out.println("zrobRezerwacje");
        Client Klient = new Client("Daniel", "Faderski", "daniel@op.pl", 
        "1234", "Warszawa", "Polna", "500", "45", "123456789",false,false,false);
        Room room = new Room("123");
        Date Begin = new Date(2015,12,12);
        Date end = new Date(2015,12,16);
        ObslugaRezerwacji instance = new ObslugaRezerwacji();
        boolean expResult = true;
        boolean result = instance.zrobRezerwacje(Klient, room, Begin, end);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    
}
