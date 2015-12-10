/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObslugaRezerwacji.zaslepki;

import java.util.List;

/**
 *
 * @author monum_000
 */
public interface IWynikiZarzadzaniaRezerwacjami {
   
    public List wyswietlHistorieRezrewacji();
    public List wyswietlListeAktywnychRezerwacji();
    public int zwrocWynikEdycjiRezerwacji();
    public int zwrocWynikSkladaniaRezerwacji();
    public int zwrocWynikUsunieciaRezerwacji();
}
