package obsluga_zarzadzania_hotelu;

import java.util.HashMap;
import systemhotelarski.RoomDAO;
import java.util.ArrayList;

public class DaneZarzadzaniaHotelu implements IDaneZarzadzaniaHotelu {

    private boolean walidujDaneHotelu(HashMap<String, Object> daneHotelu) {
        if(!(daneHotelu.get("adres") instanceof String)) {
            return false;
        }
        if(!(daneHotelu.get("liczba pokoi") instanceof Integer)) {
            return false;
        }
        if(!(daneHotelu.get("nazwa") instanceof String)) {
            return false;
        }
        if(!(daneHotelu.get("rok zalozenia") instanceof Integer)) {
            return false;
        }
        if(!(daneHotelu.get("wlasciciele") instanceof ArrayList)) {
            return false;
        }
        return true;
    }

    private boolean walidujDaneHotelu(DaneHotelu daneHotelu) {
        HashMap<String, Object> daneHoteluMap = new HashMap<>(daneHotelu.toHashMap());
        return this.walidujDaneHotelu(daneHoteluMap);
    }

    @Override
    public boolean aktualizujDaneHotelu(DaneHotelu daneHotelu) {
        throw new UnsupportedOperationException("Nie ma modelu do hotelu w DAO  - nothing to do!");
    }

    @Override
    public DaneHotelu pobierzDaneHotelu() {
        HashMap<String, Object> daneHotelu = new HashMap<>();
        RoomDAO roomDAO = new RoomDAO();
        daneHotelu.put("liczba pokoi", roomDAO.getAllRooms().size());
        // to do:
        // pobrać pozostałe dane
        return walidujDaneHotelu(daneHotelu) ? new DaneHotelu(daneHotelu) : null;
    }
}
