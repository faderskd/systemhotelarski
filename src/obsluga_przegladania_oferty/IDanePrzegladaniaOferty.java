package obsluga_przegladania_oferty;

import java.util.ArrayList;

public interface IDanePrzegladaniaOferty {

    public ArrayList<Oferta> pobierzListeOfert();

    public ArrayList<Oferta> pobierzListeOfert(Filtr filtr);
}
