
package dev.j3c.model;

import dev.j3c.domain.CarDriver;
import dev.j3c.domain.Podium;
import java.sql.Connection;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBController{
    
    public DBController(){
    }
    
    private void getParticipantData(CarDriver theCarDriver) {
        Connection conn = DBConnection.getBDConnection();
        PreparedStatement prepStmt;
        ResultSet result;
        try{
            prepStmt = conn.prepareStatement("SELECT * FROM drivers ORDER BY RAND() LIMIT 1");
            result = prepStmt.executeQuery();
            if(result.next()){
                theCarDriver.setUsername(result.getString("username_driver"));
                theCarDriver.setName(result.getString("name_driver"));
                theCarDriver.setNationality(result.getString("nationality_driver"));
            }
            
        } catch(SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            DBConnection.disconnetBD();
        }
    }
    
    private void getCarData(CarDriver theCarDriver) {
        Connection conn = DBConnection.getBDConnection();
        PreparedStatement prepStmt;
        ResultSet result;
        try{
            prepStmt = conn.prepareStatement("SELECT * FROM vehicles ORDER BY RAND() LIMIT 1");
            result = prepStmt.executeQuery();
            if(result.next()){
                theCarDriver.getVehicle().setBrand(result.getString("vehicle_brand"));
                theCarDriver.getVehicle().setColour(result.getString("vehicle_colour"));
                theCarDriver.getVehicle().setModel(result.getString("vehicle_model"));
            } 
        } catch(SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            DBConnection.disconnetBD();
        }
    }
    
    public CarDriver getRandomDriver() {
        CarDriver randomCarDriver = new CarDriver();
        if(DBConnection.connectBD()){
            this.getParticipantData(randomCarDriver);
            this.getCarData(randomCarDriver);
        }
        return(randomCarDriver);
    }

    public boolean driverExists(String driverUsername) {
        boolean driverExists = false;
        if(DBConnection.connectBD()) {
            Connection conn = DBConnection.getBDConnection();
            try {
                PreparedStatement prepStmt = conn.prepareStatement("SELECT * FROM drivers WHERE username_driver = ?");
                prepStmt.setString(1, driverUsername);
                ResultSet result = prepStmt.executeQuery();
                if(result.next()) {
                    driverExists = true;
                }
            } catch(SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return(driverExists);
    }

    private void insertNewParticipantData(){
        
    }
    
    private void insertNewCarData(){
        
    }
    
    public boolean addCarDriver(CarDriver carDriver) {
        
    }

    public List<CarDriver> getFullListCarDrivers() {
        
    }

    public List<Podium> getFullListPodiums() {
        
    }

    
    
}