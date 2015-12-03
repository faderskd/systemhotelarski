/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obsluga_zarzadzania_hotelu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class DaneZarzadzaniaHoteluTest {
    private static DaneZarzadzaniaHotelu daneZarzadzaniaHotelu;
    
    @BeforeClass
    public static void setUpClass() {
        DaneZarzadzaniaHoteluTest.daneZarzadzaniaHotelu = new DaneZarzadzaniaHotelu();
    }
    
    @AfterClass
    public static void tearDownClass() {
        DaneZarzadzaniaHoteluTest.daneZarzadzaniaHotelu = null;
    }
    
    @Test
    public void newHotelTestEmpty() {
        HashMap<String, Object> dane = new DaneHotelu().toHashMap();
        for(Object wartosc : dane.values()) {
            if(wartosc instanceof Integer) {
                assertEquals(wartosc, -1);
            } else {
                assertEquals(wartosc, null);
            }
        }
    }
    
    @Test
    public void newHotelTestWithDataCorrect() {
        HashMap<String, Object> dane = new HashMap<>();
        
        dane.put("adres", "adres1");
        dane.put("liczba pokoi", 10);
        dane.put("nazwa", "abc");
        dane.put("rok zalozenia", 2000);
        
        ArrayList<Wlasciciel> wlasciciele = new ArrayList<>();
        HashMap<String, Object> wlasciciel1 = new HashMap<>();
        wlasciciel1.put("imie", "Jan");
        wlasciciel1.put("nazwisko", "Kowalski");
        wlasciciele.add(new Wlasciciel(wlasciciel1));
        dane.put("wlasciciele", wlasciciele);
        
        assertEquals(dane, new DaneHotelu(dane).toHashMap());
    }
    
    @Test
    (expected = ClassCastException.class)
    public void newHotelTestWithDataIncorrect() {
        HashMap<String, Object> dane = new HashMap<>();
        
        dane.put("adres", 21);
        dane.put("liczba pokoi", false);
        dane.put("nazwa", new ArrayList<Object>());
        dane.put("rok zalozenia", -1);
        
        ArrayList<Wlasciciel> wlasciciele = new ArrayList<>();
        HashMap<String, Object> wlasciciel1 = new HashMap<>();
        wlasciciel1.put("imie", "Jan");
        wlasciciel1.put("nazwisko", "Kowalski");
        wlasciciele.add(new Wlasciciel(wlasciciel1));
        dane.put("wlasciciele", wlasciciele);
        
        new DaneHotelu(dane);
    }
    
    @Test
    public void pobierzDaneHoteluTest() {
        assertNotEquals(null, DaneZarzadzaniaHoteluTest.daneZarzadzaniaHotelu.pobierzDaneHotelu());
    }
    
    @Test
    public void aktualizujPobierzDaneHoteluTest() {
        HashMap<String, Object> dane = new HashMap<>();
        
        dane.put("adres", "adres1");
        dane.put("liczba pokoi", 10);
        dane.put("nazwa", "abc");
        dane.put("rok zalozenia", 2000);
        
        ArrayList<Wlasciciel> wlasciciele = new ArrayList<>();
        HashMap<String, Object> wlasciciel1 = new HashMap<>();
        wlasciciel1.put("imie", "Jan");
        wlasciciel1.put("nazwisko", "Kowalski");
        wlasciciele.add(new Wlasciciel(wlasciciel1));
        dane.put("wlasciciele", wlasciciele);
        
        DaneHotelu daneHotelu = new DaneHotelu(dane);
        
        DaneZarzadzaniaHoteluTest.daneZarzadzaniaHotelu.aktualizujDaneHotelu(daneHotelu);
        assertEquals(daneHotelu, DaneZarzadzaniaHoteluTest.daneZarzadzaniaHotelu.pobierzDaneHotelu());
    }
    
}
