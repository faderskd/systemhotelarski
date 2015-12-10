package obsluga_zarzadzania_hotelu;

import java.util.ArrayList;
import java.util.HashMap;

public class DaneHotelu {

    private String adres;
    private int liczbaPokoi;
    private String nazwa;
    private int rokZalozenia;
    private ArrayList<Wlasciciel> wlasciciele;

    // nie uzywać hash mapy!!!
    public DaneHotelu(HashMap<String, Object> daneHotelu) {
        this.adres = (String) daneHotelu.get("adres");
        this.liczbaPokoi = (int) daneHotelu.get("liczba pokoi");
        this.nazwa = (String) daneHotelu.get("nazwa");
        this.rokZalozenia = (int) daneHotelu.get("rok zalozenia");
        this.wlasciciele = (ArrayList<Wlasciciel>) daneHotelu.get("wlasciciele");
    }

    public DaneHotelu() {
        this.adres = null;
        this.liczbaPokoi = -1;
        this.nazwa = null;
        this.rokZalozenia = -1;
        this.wlasciciele = null;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public int getLiczbaPokoi() {
        return liczbaPokoi;
    }

    public void setLiczbaPokoi(int liczbaPokoi) {
        this.liczbaPokoi = liczbaPokoi;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public int getRokZalozenia() {
        return rokZalozenia;
    }

    public void setRokZalozenia(int rokZalozenia) {
        this.rokZalozenia = rokZalozenia;
    }

    public ArrayList<Wlasciciel> getWlasciciele() {
        return wlasciciele;
    }

    public void setWlasciciele(ArrayList<Wlasciciel> wlasciciele) {
        this.wlasciciele = wlasciciele;
    }
    
    public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("adres", this.adres);
        hashMap.put("liczba pokoi", this.liczbaPokoi);
        hashMap.put("nazwa", this.nazwa);
        hashMap.put("rok zalozenia", this.rokZalozenia);
        hashMap.put("wlasciciele", this.wlasciciele);
        return hashMap;
    }

}
