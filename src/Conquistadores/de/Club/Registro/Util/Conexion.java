/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conquistadores.de.Club.Registro.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Etham
 */
public class Conexion {
    private static String url="jdbc:mysql://localhost:3306/Registro?zeroDateTimeBehavior=convertToNull";
    private static String driver="com.mysql.jdbc.Driver";
    private static String user="root";
    private static String clave="root";
    private static Connection cx;
    
    public static Connection getConexion(){
        try{
            Class.forName(driver);
            if (cx==null){
                cx=DriverManager.getConnection(url, user, clave);
            }
        } catch  (ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
        return cx;    
    }
    
}
