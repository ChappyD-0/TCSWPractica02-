
package org.uv.tcswpractica2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DAOEmpleado implements IDAOGeneral<PojoEmpleado, Long> {

    @Override
    public boolean guardar(PojoEmpleado pojo) {

        ConectionDB con = ConectionDB.getInstance();
        TransactionDB  t= new TransactionDB<PojoEmpleado, Long>(pojo){
            @Override
            public boolean execute (Connection con) {
                try (PreparedStatement pst = con.prepareStatement("insert into empleados2 (clave, nombre, direccion, telefono) values (?,?,?,?)")){

                    pst.setLong(1,this.pojoDB.getClave());
                    pst.setString(2, this.pojoDB.getNombre());
                    pst.setString(3, this.pojoDB.getDireccion());
                    pst.setString(4, this.pojoDB.getTelefono());
                    pst.execute();
                    return true;
                } catch (SQLException ex){
                    Logger.getLogger(DAOEmpleado.class.getName()).log(Level.SEVERE, null, ex);
                    return false;
                }
            }
        };
        return con.execute(t);

    }

    @Override
    public PojoEmpleado eliminar(Long id) {
        PojoEmpleado obj = findById(id);
        if (obj == null) {
            return null;
        }
        String sql = "DELETE FROM empleados2 WHERE clave = '" + id + "'";
        ConectionDB con = ConectionDB.getInstance();
        boolean res = con.execute(sql);
        if (res) {
            return obj;
        }
        return null;
    }

    @Override
    public PojoEmpleado modificar(PojoEmpleado pojo, Long id) {
        String sql = "UPDATE empleados2 SET "
                + "nombre = '" + pojo.getNombre() + "', direccion = '" + pojo.getDireccion() + "', "
                + "telefono = '" + pojo.getTelefono() + "' WHERE clave = '" + id + "'";
        ConectionDB con = ConectionDB.getInstance();
        boolean res = con.execute(sql);
        if (res) {
            return findById(id);
        }
        return null;
    }

    @Override
    public PojoEmpleado findById(Long id) {
        try {
            String sql = "Select * from empleados2 where clave='"+ id + "'";
            ConectionDB con = ConectionDB.getInstance();
            ResultSet res = con.select(sql);
            if(res.next()) {
                PojoEmpleado pojo = new PojoEmpleado();
                pojo.setClave(res.getLong(1));
                pojo.setNombre(res.getString(2));
                pojo.setDireccion(res.getString(3));
                pojo.setTelefono(res.getString(4));
                return pojo;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<PojoEmpleado> findAll() {
        List<PojoEmpleado> lista = new ArrayList<>();
        try {
            String sql = "SELECT * FROM empleados2";
            ConectionDB con = ConectionDB.getInstance();
            ResultSet res = con.select(sql);
            while (res.next()) {
                PojoEmpleado pojo = new PojoEmpleado();
                pojo.setClave(res.getLong(1));
                pojo.setNombre(res.getString(2));
                pojo.setDireccion(res.getString(3));
                pojo.setTelefono(res.getString(4));
                lista.add(pojo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    
}
