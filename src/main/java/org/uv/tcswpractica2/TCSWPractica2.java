package org.uv.tcswpractica2;

import javax.swing.JOptionPane;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TCSWPractica2 {

    
    
    

    public static void main(String[] args) {
        DAOEmpleado empl = new DAOEmpleado();
        PojoEmpleado pojo = new PojoEmpleado();
        pojo.setClave(200L);
        pojo.setNombre("david");
        pojo.setDireccion("avd asd");
        pojo.setTelefono("817217381");
        boolean res = empl.guardar(pojo);
        if(res){
            Logger.getLogger(TCSWPractica2.class.getName()).log(Level.INFO, "guardado");
        } else {
                        Logger.getLogger(TCSWPractica2.class.getName()).log(Level.INFO, "No guardado");

        }
        
        
    }
}
