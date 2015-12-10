/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObslugaLogowania.zaslepki;

import systemhotelarski.Client;

/**
 *
 * @author monum_000
 */
public class zaslepkaClientDAO {
    
    public Client getClient(String login){
        return new Client("Daniel", "Faderski", "daniel@op.pl", 
        "1234", "Warszawa", "Polna", "500", "45", "123456789",false,false,false);
    }
}
