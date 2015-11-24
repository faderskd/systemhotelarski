/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObslugaLogowania;

import ObslugaLogowania.Interfaces.IDaneDostepowe;
import systemhotelarski.Client;

/**
 *
 * @author monum_000
 */
public class DaneDostepowe implements IDaneDostepowe{

    private final Client passData;
    public boolean isLogged;
    
    public DaneDostepowe(Client data) {
        passData = data;
        
    }
    
    
    @Override
    public Client przekazDane() {
        return this.passData;
    }
    
    
}
