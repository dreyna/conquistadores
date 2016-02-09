/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conquistadore.de.Club.Registro.Interfaces;

import Conquistadores.de.Club.Registro.Model.Registro;
import java.util.List;

/**
 *
 * @author Etham
 */
public interface RegistroInterface {
    public List<Registro> ListarRegistro();
    public boolean registrarRegistro(Registro r);
    public boolean modificarRegistro(Registro r);
    public boolean eliminarRegistro(int id);
   

    public List<Registro> listarProducto();
    
}
