

package org.uv.tcswpractica2;

import java.util.logging.Level;
import java.util.logging.Logger;


public class DespedidaI implements IMensaje {


    @Override
    public void imprimir() {
            Logger.getLogger(DespedidaI.class.getName()).log(Level.INFO, "Despedida mundo...");
    }




}
