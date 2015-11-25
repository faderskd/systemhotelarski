package obsluga_przegladania_oferty;

import java.util.ArrayList;
import java.util.List;

import systemhotelarski.OfferDAO;
import systemhotelarski.Offer;
import systemhotelarski.RoomDAO;
import systemhotelarski.Room;
import util.Pair;

public class DanePrzegladaniaOferty implements IDanePrzegladaniaOferty {

    private OfferDAO offerDAO;
    private RoomDAO roomDAO;

    public DanePrzegladaniaOferty() {
        this.offerDAO = new OfferDAO();
        this.roomDAO = new RoomDAO();
    }

    @Override
    public ArrayList<Oferta> pobierzListeOfert() {
        List listaOfert = offerDAO.getAllOffers();
        ArrayList<Oferta> oferty = new ArrayList<>();
        // co to za lista?
        for (Object obiekt : listaOfert) {
            Offer obiektOferty = (Offer) obiekt;
            try {
                Oferta oferta = new Oferta(obiektOferty);
                oferty.add(oferta);
            } catch (BladOferty bladOferty) {
                bladOferty.printStackTrace();
            }
        }
        return oferty;
    }

    private boolean sprawdzOpisOferty(ArrayList<String> frazy, String opis) {
        if (frazy.size() == 0) {
            return true;
        }
        for (String fraza : frazy) {
            if (opis.contains(fraza)) {
                return true;
            }
        }
        return false;
    }

    private boolean sprawdzPojemnoscOferty(Pair<Integer, Integer> zakresPojemnosci, int pojemnoscOferty) {
        if (zakresPojemnosci.getFirst() != null && zakresPojemnosci.getFirst() > pojemnoscOferty) {
            return false;
        }
        if (zakresPojemnosci.getSecond() != null && zakresPojemnosci.getSecond() < pojemnoscOferty) {
            return false;
        }
        return true;
    }

    private boolean sprawdzCeneOferty(Pair<Double, Double> zakresCen, double cenaOferty) {
        if(zakresCen.getFirst() != null && zakresCen.getFirst() > cenaOferty) {
            return false;
        }
        if(zakresCen.getSecond() != null && zakresCen.getSecond() < cenaOferty) {
            return false;
        }
        return true;
    }

    @Override
    public ArrayList<Oferta> pobierzListeOfert(Filtr filtr) {
        ArrayList<Oferta> oferty = this.pobierzListeOfert();
        ArrayList<Oferta> przefiltrowaneOferty = new ArrayList<>();
        for (Oferta oferta : oferty) {
            if(
                    this.sprawdzOpisOferty(filtr.pobierzFrazyOpisu(), oferta.getOpisOferty()) &&
                    this.sprawdzPojemnoscOferty(filtr.pobierzZakresPojemnosciOferty(), oferta.getPojemnoscOferty()) &&
                    this.sprawdzCeneOferty(filtr.pobierzZakresCenOferty(), oferta.getCenaOferty())
            ) {
                przefiltrowaneOferty.add(oferta);
            }
        }
        return oferty;
    }
}
