package obsluga_przegladania_oferty;

import java.util.HashMap;
import java.util.ArrayList;
import util.Pair;

public class Filtr {
    
    private ArrayList<String> opisOferty;
    private Pair<Integer, Integer> pojemnoscOferty;
    private Pair<Double, Double> cenaOferty;

    public Filtr() {
    }
    
    public void dodajFrazeOpisu(String fraza) {
        this.opisOferty.add(fraza);
    }
    
    public void dodajMinPojemnoscOferty(int pojemnosc) {
        this.pojemnoscOferty.setFirst(pojemnosc);
    }
    
    public void dodajMaksPojemnoscOferty(int pojemnosc) {
        this.pojemnoscOferty.setSecond(pojemnosc);
    }
    
    public void dodajMinCeneOferty(double cena) {
        this.cenaOferty.setFirst(cena);
    }
    
    public void dodajMaksCeneOferty(double cena) {
        this.cenaOferty.setSecond(cena);
    }
    
    public ArrayList<String> pobierzFrazyOpisu() {
        return this.opisOferty;
    }
    
    public Pair<Integer, Integer> pobierzZakresPojemnosciOferty() {
        return this.pojemnoscOferty;
    }
    
    public Pair<Double, Double> pobierzZakresCenOferty() {
        return this.cenaOferty;
    }
}
