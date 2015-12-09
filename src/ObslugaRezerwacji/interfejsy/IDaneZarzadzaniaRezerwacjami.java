/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObslugaRezerwacji.interfejsy;

import java.util.Date;
import systemhotelarski.Client;
import systemhotelarski.Reservation;
import systemhotelarski.Room;

/**
 *
 * @author monum_000
 */
public interface IDaneZarzadzaniaRezerwacjami {
    public boolean edytujRezerwacje(Reservation rezerwacja, Reservation nowaRezerwacja);
    public boolean kasujRezerwacje(Reservation rezerwacja);
    public boolean zrobRezerwacje(Client Klient, Room room, Date Begin, Date end); 
}
