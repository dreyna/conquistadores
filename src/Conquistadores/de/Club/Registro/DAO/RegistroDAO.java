/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conquistadores.de.Club.Registro.DAO;

import Conquistadore.de.Club.Registro.Interfaces.RegistroInterface;
import Conquistadores.de.Club.Registro.Model.Registro;
import Conquistadores.de.Club.Registro.Util.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Etham
 */
public class RegistroDAO implements RegistroInterface {
    private Statement st;
    private ResultSet rs;
    private Connection cx;
    private String sql;

    @Override
    public List<Registro> ListarRegistro() {
        List<Registro> lista = new ArrayList<>();
        sql="SELECT *FROM Registro";
        try {
            cx= Conexion.getConexion();
            st= cx.createStatement();
            rs= st.executeQuery(sql);
            while(rs.next()){
                Registro r = new Registro();
                r.setIdr(rs.getInt("idregistro"));
                r.setNombre(rs.getString("Nombre"));
                r.setApellido(rs.getString("Apellido"));
                r.setDni(rs.getInt("DNI"));
                r.setEdad(rs.getInt("Edad"));
                r.setClase(rs.getString("Clse"));
                r.setUnidad(rs.getString("Unidad"));
                r.setCorreo(rs.getString("Correo Electronico"));
                r.setTelefono(rs.getInt(" Telefono"));
                r.setDetalle(rs.getString("Observacion"));
                lista.add(r);
            }
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return lista;
    }

    @Override
    public boolean registrarRegistro(Registro r) { 
        boolean op=false;
        sql="INSERT INTO  Registro ( idregistro, Nombre, Apellido, DNI, Edad, Clase, Unidad, Correo Electronico,Telefono,Observacion)" +
            "VALUES(NULL,'"+r.getNombre()+"', '"+r.getApellido()+"', '"+r.getDni()+"', '"+r.getEdad()+"', '"+r.getClase()+
                    "', '"+r.getUnidad()+ "', '"+r.getCorreo()+"', '"+r.getTelefono()+"', '"+r.getDetalle()+")";
        
        
        
        try{
            cx = Conexion.getConexion();
            st = cx.createStatement();
            int w = st.executeUpdate(sql);
            if(w>0){
                op= true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        return op;
        
    }

    @Override
    public boolean modificarRegistro(Registro r) {
         boolean op=false;
         sql="";
         
         
         
         
        sql="UPDATE producto SET nom_producto = '"+p.getNomprod()+"',"+
        "precio = "+p.getPrecio()+",cantidad = " +p.getCant()+" WHERE idproducto="+p.getIdp();
        try{
          cx = Conexion.getConexion();
          st = cx.createStatement();
          int w = st.executeUpdate(sql);
          if(w>0){
              op = true;
          } 
          } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return op;
        
    }

    @Override
    public boolean eliminarRegistro(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Registro> listarProducto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
