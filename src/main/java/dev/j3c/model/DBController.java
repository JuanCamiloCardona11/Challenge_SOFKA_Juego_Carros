
package dev.j3c.model;

import dev.j3c.domain.CarDriver;
import dev.j3c.domain.Podium;
import java.util.List;

public class DBController{

    private DBConnection DBConn;
    
    public DBController(){
        this.DBConn = new DBConnection();
    }
    
    public CarDriver getRandomDriver() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean driverExists(String driverUsername) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean addCarDriver(CarDriver carDriver) {
        return(true);
    }

    public List<CarDriver> getFullListCarDrivers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Podium> getFullListPodiums() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}