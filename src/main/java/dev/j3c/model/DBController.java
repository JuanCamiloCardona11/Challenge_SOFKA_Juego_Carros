
package dev.j3c.model;

import dev.j3c.domain.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
            } finally {
                DBConnection.disconnetBD();
            }
        }
        return(driverExists);
    }

    private boolean insertNewParticipantData(CarDriver carDriver){
        boolean driverRegistred = false;
        if(DBConnection.connectBD()) {
            Connection conn = DBConnection.getBDConnection();
            PreparedStatement prepStmt;
            try {
                prepStmt = conn.prepareStatement("INSERT INTO drivers (name_driver, username_driver,nationality_driver) VALUES (?,?,?)");
                prepStmt.setString(1, carDriver.getName());
                prepStmt.setString(2, carDriver.getUsername());                
                prepStmt.setString(3, carDriver.getNationality());
                int result = prepStmt.executeUpdate();
                if(result > 0) driverRegistred = true;
            } catch(SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }        
        return(driverRegistred);
    }
    
    private boolean insertNewCarData(CarDriver carDriver){
        boolean carRegistred = false;
        if(DBConnection.connectBD()) {
            Connection conn = DBConnection.getBDConnection();
            PreparedStatement prepStmt;
            try {
                prepStmt = conn.prepareStatement("INSERT INTO vehicles (vehicle_brand, vehicle_colour,vehicle_model) VALUES (?,?,?)");
                prepStmt.setString(1, carDriver.getVehicle().getBrand());
                prepStmt.setString(2, carDriver.getVehicle().getColour());                
                prepStmt.setString(3, carDriver.getVehicle().getModel());
                int result = prepStmt.executeUpdate();
                if(result > 0) carRegistred = true;
            } catch(SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }        
        return(carRegistred);
    }
    
    public boolean addCarDriver(CarDriver carDriver) {
        boolean result1 = false, result2 = false;
        if(DBConnection.connectBD()){
            result1 = this.insertNewParticipantData(carDriver);
            result2 = this.insertNewCarData(carDriver);
        }
        return(result1 && result2);
    }

    public CarDriver constructCarDriver(ResultSet result) throws SQLException{
        CarDriver theCarDriver = new CarDriver();
        String name = result.getString("name_driver"),
            username = result.getString("username_driver"), 
            nationality = result.getString("nationality_driver");       
        theCarDriver.setName(name);
        theCarDriver.setUsername(username);
        theCarDriver.setNationality(nationality);
        return(theCarDriver);
    }
    
    public List<CarDriver> getFullListCarDrivers() {
        List<CarDriver> carDriversList = new ArrayList<>();
        if(DBConnection.connectBD()){
            Connection conn = DBConnection.getBDConnection();
            PreparedStatement prepStmt;
            ResultSet result;
            try{
                prepStmt = conn.prepareStatement("SELECT * FROM drivers ORDER BY races_won DESC");
                result = prepStmt.executeQuery();
                while(result.next()){
                    CarDriver theCarDriver = this.constructCarDriver(result);
                    carDriversList.add(theCarDriver);
                }
            } catch(SQLException ex) {
                ex.printStackTrace(System.out);
            } finally {
                DBConnection.disconnetBD();
            }
        }    
        return(carDriversList);
    }
    
    public Podium constructPodium(ResultSet result) throws SQLException{
        Podium thePodium;
        int competitionLength = result.getInt("competition_length");
        String firsPlaceName = result.getString("name_driver"),
            firstPlaceNationality = result.getString("nationality_driver"), 
            secondPlaceName = result.getString("name_driver"),
            secondPlaceNationality = result.getString("nationality_driver"), 
            thirdPlaceName = result.getString("name_driver"),
            thirdPlaceNationality = result.getString("nationality_driver");
        CarDriver firstPlaceDriver = new CarDriver(firsPlaceName, firstPlaceNationality),
            SecondPlaceDriver = new CarDriver(secondPlaceName, secondPlaceNationality),
            thirdPlaceDriver = new CarDriver(thirdPlaceName, thirdPlaceNationality);
        thePodium = new Podium(firstPlaceDriver, SecondPlaceDriver, thirdPlaceDriver,competitionLength);  
        return(thePodium);
    }

    public List<Podium> getFullListPodiums() {
        List<Podium> podiumsList = new ArrayList<>();
        if(DBConnection.connectBD()){
            Connection conn = DBConnection.getBDConnection();
            PreparedStatement prepStmt;
            ResultSet result;
            try{
                prepStmt = conn.prepareStatement("SELECT * FROM podiums");
                result = prepStmt.executeQuery();
                while(result.next()){
                    Podium thePodium = this.constructPodium(result);
                    podiumsList.add(thePodium);
                }
            } catch(SQLException ex) {
                ex.printStackTrace(System.out);
            } finally {
                DBConnection.disconnetBD();
            }
        }
        return(podiumsList);
    }

    
    
}