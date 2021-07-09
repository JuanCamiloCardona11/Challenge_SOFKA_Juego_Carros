
package dev.j3c.model;

import dev.j3c.domain.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

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
            JOptionPane.showMessageDialog(null, "Error al intentar obtener la informacion del conductor: \n" + ex.getMessage(),"Error en la Base de Datos", 0);
        }   
    }
    
    private void getCarData(int idParticipant, CarDriver theCarDriver) {
        if (DBConnection.connectBD()) {
            Connection conn = DBConnection.getBDConnection();
            PreparedStatement prepStmt;
            ResultSet result;
            try{
                prepStmt = conn.prepareStatement("SELECT * FROM vehicles WHERE id_vehicle = ? LIMIT 1");
                prepStmt.setInt(1, idParticipant);
                result = prepStmt.executeQuery();
                if(result.next()) {
                    String brand = result.getString("vehicle_brand");
                    String colour = result.getString("vehicle_colour");
                    String model = result.getString("vehicle_model");
                    theCarDriver.setVehicle(new Vehicle(brand, colour, model));
                } 
            } catch(SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al intentar obtener la informacion del auto perteneciente al conductor: \n" + ex.getMessage(),"Error en la Base de Datos", 0);
            } finally {
                DBConnection.disconnetBD();
            }
        }
    }
    
     private int getIdParticipant(String username) {
        int idParticipant = 1;
        if(DBConnection.connectBD()) {
            Connection conn = DBConnection.getBDConnection();
            PreparedStatement prepStmt;
            ResultSet result;
            try{
                prepStmt = conn.prepareStatement("SELECT id_driver FROM drivers WHERE username_driver = ?");
                prepStmt.setString(1, username);
                result = prepStmt.executeQuery();
                if(result.next()){
                    idParticipant = result.getInt("id_driver");
                } 
            } catch(SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al intentar obtener la informacion del conductor: \n" + ex.getMessage(),"Error en la Base de Datos", 0);
            } finally {
                DBConnection.disconnetBD();
            }
        }
        return(idParticipant);
    }
    
    public CarDriver getRandomDriver() {
        CarDriver randomCarDriver = new CarDriver();
        if(DBConnection.connectBD()){
            this.getParticipantData(randomCarDriver);
            int idDriver = this.getIdParticipant(randomCarDriver.getUsername());
            this.getCarData(idDriver, randomCarDriver);
            DBConnection.disconnetBD();
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
                JOptionPane.showMessageDialog(null, "Error al intentar verificar la existencia del conductor: \n" + ex.getMessage(),"Error en la Base de Datos", 0);
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
                JOptionPane.showMessageDialog(null, "Error al intentar insertar la informacion del nuevo conductor: \n" + ex.getMessage(),"Error en la Base de Datos", 0);
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
                JOptionPane.showMessageDialog(null, "Error al intentar insertar la informacion del nuevo auto: \n" + ex.getMessage(),"Error en la Base de Datos", 0);
            }
        }
        return(carRegistred);
    }
    
    public boolean addCarDriver(CarDriver carDriver) {
        boolean result1 = false, result2 = false;
        if(DBConnection.connectBD()){
            result1 = this.insertNewParticipantData(carDriver);
            result2 = this.insertNewCarData(carDriver);
            DBConnection.disconnetBD();
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
                prepStmt = conn.prepareStatement("SELECT * FROM drivers");
                result = prepStmt.executeQuery();
                while(result.next()){
                    CarDriver theCarDriver = this.constructCarDriver(result);
                    carDriversList.add(theCarDriver);
                }
            } catch(SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al intentar obtener la informacion de todos los conductores existentes en el sistema: \n" + ex.getMessage(),"Error en la Base de Datos", 0);
            } finally {
                DBConnection.disconnetBD();
            }
        }    
        return(carDriversList);
    }
    
    public Podium constructPodium(ResultSet result) throws SQLException{
        Podium thePodium;
        int competitionLength = result.getInt("competition_length");
        String firsPlaceName = result.getString("first_place_name"),
            firstPlaceNationality = result.getString("first_place_nationality"), 
            secondPlaceName = result.getString("second_place_name"),
            secondPlaceNationality = result.getString("second_place_nationality"), 
            thirdPlaceName = result.getString("third_place_name"),
            thirdPlaceNationality = result.getString("third_place_nationality");
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
                JOptionPane.showMessageDialog(null, "Error al intentar obtener la informacion de todos los podios existentes en el sistema: \n" + ex.getMessage(),"Error en la Base de Datos", 0);
            } finally {
                DBConnection.disconnetBD();
            }
        }
        return(podiumsList);
    }

    public boolean addNewPodium(CarDriver firstPositionDriver, CarDriver secondPositionDriver, CarDriver thirdPositionDriver, int raceLength) {
        boolean podiumRegistred = false;
        if(DBConnection.connectBD()) {
            Connection conn = DBConnection.getBDConnection();
            PreparedStatement prepStmt;
            try {
                prepStmt = conn.prepareStatement("INSERT INTO podiums (competition_length, first_place_name, first_place_nationality, second_place_name, second_place_nationality, third_place_name, third_place_nationality) VALUES (?,?,?,?,?,?,?)");
                prepStmt.setInt(1, raceLength/1000);
                prepStmt.setString(2, firstPositionDriver.getName());               
                prepStmt.setString(3, firstPositionDriver.getNationality());
                prepStmt.setString(4, secondPositionDriver.getName());               
                prepStmt.setString(5, secondPositionDriver.getNationality());
                prepStmt.setString(6, thirdPositionDriver.getName());               
                prepStmt.setString(7, thirdPositionDriver.getNationality());
                int result = prepStmt.executeUpdate();
                if(result > 0) podiumRegistred = true;
            } catch(SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al intentar insertar un nuevo podio en el sistema: \n" + ex.getMessage(),"Error en la Base de Datos", 0);
            } finally {
                DBConnection.disconnetBD();
            }
        }
        return(podiumRegistred);        
    } 
    
    public int getNumberOfDrivers(){
        int numberOfDrivers = -1;
        if(DBConnection.connectBD()){
            Connection conn = DBConnection.getBDConnection();
            PreparedStatement prepStmt;
            ResultSet result;
            try{
                prepStmt = conn.prepareStatement("SELECT COUNT(*) FROM drivers");
                result = prepStmt.executeQuery();
                if(result.next()) {
                    numberOfDrivers = result.getInt(1);
                }
            } catch(SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al intentar obtener la informacion de todos los podios existentes en el sistema: \n" + ex.getMessage(),"Error en la Base de Datos", 0);
            } finally {
                DBConnection.disconnetBD();
            }
        }
        return(numberOfDrivers);
    }
}