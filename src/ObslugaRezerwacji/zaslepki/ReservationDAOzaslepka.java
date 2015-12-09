/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObslugaRezerwacji.zaslepki;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Random;
import systemhotelarski.Client;
import systemhotelarski.Reservation;
import systemhotelarski.Room;

/**
 *
 * @author monum_000
 */
public class ReservationDAOzaslepka  {
        private ArrayList<Reservation> listarez;
        
    public ReservationDAOzaslepka(){
        this.listarez = new ArrayList<>();
        Random rng = new Random();
        for(int i = 0; i<10;i++){
            //String slownik = "abcdefghijklmnoperstuwxyz";
            Reservation rezerwacja;
            rezerwacja = new Reservation(this.generateRandomClient(i),new Date(2015,7,15), new Date(2015,7,19),new Room(Integer.toString(i+7)));
            listarez.add(rezerwacja);
        }
    }
    public static void main(String[] args){
        ReservationDAOzaslepka zaslepka = new ReservationDAOzaslepka();
        
    }
    public int addReservation(Reservation nowa) {
        this.listarez.add(nowa);
        return 1;
    }
    
    public ArrayList<Reservation> getAllReservations() {
        return this.listarez;
    }
    
    public void updateReservation() {
        
    }
    
    public void deleteReservation() {
        
    }
    private static String generateString(Random rng, String characters, int length)
        {
        char[] text = new char[length];
        for (int i = 0; i < length; i++)
            {
                text[i] = characters.charAt(rng.nextInt(characters.length()));
            }
        return new String(text);
        }
    private Client generateRandomClient(int id){
        Client klient = new Client();
        Random rng = new Random();
        klient.setApartmentNumber(generateString(rng, "0123456789",4));
        klient.setBuildingNumber(generateString(rng, "0123456789",4));
        klient.setCity(generateString(rng, "abcdefghijklmnoprstuwxyz",4));
        klient.setEmail(generateString(rng, "abcdefghijklmnoprstuwxyz",4));
        klient.setFirstName(generateString(rng, "abcdefghijklmnoprstuwxyz",4));
        klient.setId(id);
        klient.setIsAdmin(false);
        klient.setIsEmployee(false);
        klient.setIsManager(false);
        klient.setLastName(generateString(rng, "abcdefghijklmnoprstuwxyz",4));
        klient.setPassword(generateString(rng, "abcdefghijklmnoprstuwxyz",4));
        klient.setStreet(generateString(rng, "abcdefghijklmnoprstuwxyz",4));
        klient.setTelephoneNumber(generateString(rng, "abcdefghijklmnoprstuwxyz",4));
       
        return klient;
    }
}
