package dev.j3c.model;

import javax.swing.JOptionPane;
import java.sql.*;

public class DBConnection {
    
    private static final String URL = "jdbc:mysql://localhost:3306/challenge_sofka?UseSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String USER = "root";
    private static final String PASSWORD = "mysql12345ROOT";
    private static Connection connBD;
    
    public DBConnection(){
    }
    
    public static boolean connectBD() {
        boolean connStatusBD = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connBD = (Connection) DriverManager.getConnection(URL, USER, PASSWORD);
            connStatusBD = true;
        } catch ( ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al intentar obtener una conexion con la BD: \n" + ex.getMessage(),"Error en la Base de Datos", 0);
        }
        return(connStatusBD);
    }
    
    public static Connection getBDConnection(){
        return(DBConnection.connBD);
    }
    
    public static void disconnetBD() {
        if (connBD != null) {
            try {
                connBD.close();
                connBD = null;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al intentar desconectar la base de datos: \n" + ex.getMessage(),"Error en la Base de Datos", 0);
            }
        }
    }    
}
