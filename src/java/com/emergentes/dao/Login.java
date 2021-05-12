
package com.emergentes.dao;

import com.emergentes.utiles.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Login extends ConexionBD {

    public boolean autentication(String usuario, String contraseña) {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String log = "select * from usuarios where usuario =? and password =?";
            ps = conectar().prepareStatement(log);
            ps.setString(1, usuario);
            ps.setString(2, contraseña);
            rs = ps.executeQuery();

            if (rs.absolute(1)) {
                return true;
            }

        } catch (Exception e) {
            System.out.println("Error"+e.getMessage());
        }finally{
            
                try {
                   if(conectar() != null) conectar().close();
                   
                } catch (SQLException ex) {
                    System.out.println("Error"+ex.getMessage());
                }
            
        }
        return false;
    }
    
    
  

}
