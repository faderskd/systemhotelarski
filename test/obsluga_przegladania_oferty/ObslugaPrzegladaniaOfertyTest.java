package obsluga_przegladania_oferty;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import obsluga_przegladania_oferty.DanePrzegladaniaOferty;

public class ObslugaPrzegladaniaOfertyTest {
    
    @Test
    public void testPobierzListeOfert() {
        System.out.println("pobierzListeOfert()");
        IDanePrzegladaniaOferty danePrzegladaniaOferty = new DanePrzegladaniaOferty();
        assertTrue(danePrzegladaniaOferty.pobierzListeOfert() instanceof ArrayList);
    }

    @Test
    public void testPobierzListeOfert_Filtr() {
        System.out.println("pobierzListeOfert(Filtr filtr)");
        IDanePrzegladaniaOferty danePrzegladaniaOferty = new DanePrzegladaniaOferty();
        assertTrue(danePrzegladaniaOferty.pobierzListeOfert(new Filtr())instanceof ArrayList);
    }
    
}
