package obsluga_zarzadzania_hotelu;

import java.util.HashMap;

public class Wlasciciel {

    private String imie;
    private String nazwisko;

    public Wlasciciel(HashMap<String, Object> daneWlasciciela) {
        this.imie = (String) daneWlasciciela.get("imie");
        this.nazwisko = (String) daneWlasciciela.get("nazwisko");
    }

    public Wlasciciel() {
        this.imie = null;
        this.nazwisko = null;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

}
