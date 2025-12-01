
package org.uv.tcswpractica2;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SaludoI implements IMensaje {


    @Override
    public void imprimir() {
            Logger.getLogger(SaludoI.class.getName()).log(Level.INFO, "Hola mundo...");
    }




}
