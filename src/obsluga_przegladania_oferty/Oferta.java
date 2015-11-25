package obsluga_przegladania_oferty;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import systemhotelarski.Offer;
import systemhotelarski.Room;

public class Oferta {

    // oferta
    private final int idOferty;
    private final String opisOferty;
    private final int pojemnoscOferty;
    private final String obrazekOferty;
    private final double cenaOferty;
    // pokoj
    private final int idPokoju;
    private final String numerPokoju;

    public Oferta(Offer oferta) throws BladOferty {
        // oferta
        this.idOferty = oferta.getId();
        this.opisOferty = oferta.getDescription();
        this.pojemnoscOferty = oferta.getNumberOfPeople();
        this.obrazekOferty = oferta.getImage();
        this.cenaOferty = oferta.getPrice();
        // pokoj
        Room pokoj = oferta.getRoom();
        this.idPokoju = pokoj.getId();
        this.numerPokoju = pokoj.getNumber();
        
        // sprawdzenie, czy dane są poprawne
        Pattern wzorzec = Pattern.compile("\\d*\\d\\w");
        if(this.idOferty < 0) {
            throw new BladOferty(String.format("niepoprawne id oferty: %d", this.idOferty));
        }
        if(this.pojemnoscOferty < 0) {
            throw new BladOferty(String.format("niepoprawne liczba osob w ofercie: %d", this.pojemnoscOferty));
        }
        if(this.cenaOferty < 0) {
            throw new BladOferty(String.format("niepoprawna cena oferty: %f", this.cenaOferty));
        }
        if(this.idPokoju < 0) {
            throw new BladOferty(String.format("niepoprawne id pokoju: %d", this.idPokoju));
        }
        if(!wzorzec.matcher(this.numerPokoju).matches()) {
            throw new BladOferty(String.format("niepoprawne numer pokoju: %s", this.numerPokoju));
        }
    }
    
    // GET
    public int getIdOferty() {
        return idOferty;
    }

    public String getOpisOferty() {
        return opisOferty;
    }

    public int getPojemnoscOferty() {
        return pojemnoscOferty;
    }

    public String getObrazekOferty() {
        return obrazekOferty;
    }

    public double getCenaOferty() {
        return cenaOferty;
    }

    public int getIdPokoju() {
        return idPokoju;
    }

    public String getNumerPokoju() {
        return numerPokoju;
    }
}
