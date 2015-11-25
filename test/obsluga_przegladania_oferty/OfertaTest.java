package obsluga_przegladania_oferty;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import systemhotelarski.Offer;
import systemhotelarski.Room;
import obsluga_przegladania_oferty.BladOferty;
import obsluga_przegladania_oferty.Oferta;

public class OfertaTest {

    // WALIDACJA PODCZAS TWORZENIA NOWEGO OBIEKTU OFERTY
    
    @Test
    (expected = BladOferty.class)
    public void testOferta1() throws BladOferty {
        System.out.println("Oferta(Offer oferta) throws BladOferty");
        Offer ofertaObiekt = new Offer("przykladowy opis", -1, "", 1, new Room("1a"));
        Oferta oferta = new Oferta(ofertaObiekt);
    }
    @Test
    (expected = BladOferty.class)
    public void testOferta2() throws BladOferty {
        System.out.println("Oferta(Offer oferta) throws BladOferty");
        Offer ofertaObiekt = new Offer("przykladowy opis", 1, "", -1, new Room("1a"));
        Oferta oferta = new Oferta(ofertaObiekt);
    }
    @Test
    (expected = BladOferty.class)
    public void testOferta3() throws BladOferty {
        System.out.println("Oferta(Offer oferta) throws BladOferty");
        Offer ofertaObiekt = new Offer("przykladowy opis", 1, "", 1, new Room("a"));
        Oferta oferta = new Oferta(ofertaObiekt);
    }

}
