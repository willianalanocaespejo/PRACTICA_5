
package com.emergentes.utiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    
    static String driver ="com.mysql.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306/bdblog";
    static String usuario = "root";
    static String password = "";
  protected  Connection conn = null;
    public ConexionBD() {
        try {
            Class.forName(driver);            
            conn = DriverManager.getConnection(url, usuario, password);
            if (conn != null) {
                System.out.println("Conexion exitosa" + conn);
            }

        } catch (ClassNotFoundException e ) {
            System.out.println("Error de Driver" + e.getMessage());
        } catch (SQLException e){
            System.out.println("Error al conectar"+e.getMessage());
        }
    }
    public Connection conectar() {
        return conn;
    }
    public void desconectar() {   
        System.out.println("Cerrando la BD" +conn);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Error al cerrar la conexion" + ex.getMessage());
        }
    }
    
}
