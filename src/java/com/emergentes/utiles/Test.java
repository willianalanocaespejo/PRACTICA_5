
package com.emergentes.utiles;

import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws SQLException{
        ConexionBD con = new ConexionBD();
        
        con.conectar();
    }
}
