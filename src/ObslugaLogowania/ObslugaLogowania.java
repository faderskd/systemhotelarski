/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObslugaLogowania;

import ObslugaLogowania.Interfaces.IDaneDostepowe;
import ObslugaLogowania.Interfaces.IDaneLogowania;
import ObslugaLogowania.zaslepki.DataTransferZaslepka;
import ObslugaLogowania.zaslepki.zaslepkaClientDAO;
import java.util.ArrayList;
import java.util.List;
import systemhotelarski.Client;

/**
 *
 * @author monum_000
 */
public class ObslugaLogowania {
    
    public IDaneLogowania zaslepka;
    private XDaneLogowania przekazaneDane;
    public Client dataToPass;
    
    public ObslugaLogowania(){
        
        // sprwdzic czy w login i pass zgadza sie z baza
        
        // zwrocic -1 jezeli sie nie zgadza
        
        // zwrocic dataToPass jezeli sie zgadza
        
        //powymieniac zaslepki, 
        this.zaslepka = new DataTransferZaslepka();
        this.przekazaneDane = zaslepka.przekazDane();
        
        boolean isLogged = zaloguj(this.przekazaneDane);
        if(isLogged){
            DaneDostepowe dst = new DaneDostepowe(dataToPass);
            
        }else{
            System.out.println("Nie zalogowano");
        }
        
    }
    
    public static void main(String[] args){
        ObslugaLogowania zenon = new ObslugaLogowania();
    }
    private boolean zaloguj(XDaneLogowania dane){
        List<Client> lista = new ArrayList();
        //zaslepka
        zaslepkaClientDAO zasl = new zaslepkaClientDAO();
        lista.add(zasl.getClient("cokolwiek"));
        //zaslepka
        for(Client v : lista){
            if(v.getEmail().equals(dane.getLogin())){
                if(v.getPassword().equals(dane.getPassword())){
                    this.dataToPass = v;
                    return true;
                }
            }
        }
        
        return false;
    }
}
