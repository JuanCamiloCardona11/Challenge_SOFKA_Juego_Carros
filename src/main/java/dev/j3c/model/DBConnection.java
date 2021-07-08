package dev.j3c.model;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


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
        } catch ( ClassNotFoundException ex1) {
            ex1.printStackTrace(System.out);
        } catch (SQLException ex2) {
            ex2.printStackTrace(System.out);
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
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al intentar desconectar la base de datos, intente nuevamente.");
            }
        }
    }    
}
