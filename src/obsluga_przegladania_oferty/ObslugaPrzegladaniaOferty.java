package obsluga_przegladania_oferty;

public class ObslugaPrzegladaniaOferty {
    private IDanePrzegladaniaOferty danePrzegladaniaOferty;
    
    public void ustawDanePrzegladaniaOferty(IDanePrzegladaniaOferty danePrzegladaniaOferty) {
        this.danePrzegladaniaOferty = danePrzegladaniaOferty;
    }
    public IDanePrzegladaniaOferty pobierzDanePrzegladaniaOferty() {
        return this.danePrzegladaniaOferty;
    }
}
