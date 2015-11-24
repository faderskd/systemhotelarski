/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObslugaLogowania.zaslepki;

import ObslugaLogowania.Interfaces.IDaneLogowania;
import ObslugaLogowania.XDaneLogowania;

/**
 *
 * @author monum_000
 */
public class DataTransferZaslepka implements IDaneLogowania{

    @Override
    public XDaneLogowania przekazDane() {
        return new XDaneLogowania("daniel@op.pl","1234");
    }
    
}
