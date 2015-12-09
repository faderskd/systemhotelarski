/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObslugaRezerwacji;

import ObslugaRezerwacji.interfejsy.IDaneZarzadzaniaRezerwacjami;
import ObslugaRezerwacji.interfejsy.IWyswietlanieRezerwacji;
import ObslugaRezerwacji.zaslepki.ReservationDAOzaslepka;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import systemhotelarski.Client;
import systemhotelarski.Reservation;
import systemhotelarski.Room;

/**
 *
 * @author monum_000
 */
public class ObslugaRezerwacji implements IDaneZarzadzaniaRezerwacjami, IWyswietlanieRezerwacji {
    
    private ArrayList<Reservation> rezerwacje;
    private ReservationDAOzaslepka dao;
    
    public ObslugaRezerwacji(){
        this.dao = new ReservationDAOzaslepka();
        this.rezerwacje = dao.getAllReservations();
        
    }
    
    
//metody z interfejsów
    @Override
    public boolean edytujRezerwacje(Reservation rezerwacja,  Reservation nowaRezerwacja) {
        for(Reservation e : this.rezerwacje){
            if(e.equals(rezerwacja)){
                e = nowaRezerwacja;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean kasujRezerwacje(Reservation rezerwacja) {
        for(Reservation e : this.rezerwacje){
            if(e.equals(rezerwacja)){
                rezerwacje.remove(e);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean zrobRezerwacje(Client Klient, Room room, Date Begin, Date end) {
        Reservation nowa = new Reservation(Klient, Begin, end, room);
        if(dao.addReservation(nowa) != 1)return false; else {
            return true;
        }
    }

    @Override
    public ArrayList<Reservation> wyswietlListeRezerwacji() {
        return this.rezerwacje;
    }
    
    
}
