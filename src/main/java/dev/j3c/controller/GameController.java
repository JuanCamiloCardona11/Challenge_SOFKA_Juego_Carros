
package dev.j3c.controller;

import dev.j3c.domain.CarDriver;
import dev.j3c.domain.Podium;
import dev.j3c.domain.RaceTrack;
import dev.j3c.domain.TrackLane;
import dev.j3c.domain.Vehicle;
import dev.j3c.model.DBController;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class GameController {
    private RaceTrack currentRaceTrack;
    private DBController DBControl;

    public GameController(){
        this.DBControl = new DBController();
    }
    
    public RaceTrack getCurrentRaceTrack() {
        return currentRaceTrack;
    }

    public void setCurrentRaceTrack(RaceTrack newRaceTrack) {
        this.currentRaceTrack = newRaceTrack;
    }

    public List<Podium> getFullListPodiums() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean validateNewUsername(String driverUsername) {
        boolean validUsername = false;
        if(driverUsername.matches("^[a-z0-9_-]{3,50}$")){
            if(!this.DBControl.driverExists(driverUsername)){
                validUsername = true;
            } else {
                JOptionPane.showMessageDialog(null, "El corredor con nombre de usuario: " + driverUsername + " ya se encuentra registrado en el sistema, intente con uno nuevo la siguiente vez.","Nombre de Usuario Existente.", 2);
            }
        } else {
            JOptionPane.showMessageDialog(null, "El nombre de usuario debe tener el formato ^[a-z0-9_-]{3,50}$.","Formato invalido", 0);
        }
        return(validUsername);
    }

    private String validateStringInput(String dato, int maxLength) {
        String fullName = "";
        while(!fullName.matches("^[a-zA-Z ]{3," + String.valueOf(maxLength) + "}$")){
            fullName = JOptionPane.showInputDialog(null,"Por favor ingrese " + dato + " del nuevo usuario: ","Ingreso de Datos del Nuevo Corredor",3);
        }
        return(fullName);
    }
    
    public void getNewDriverData(String driverUsername) {
        String name = this.validateStringInput("el nombre", 100),
            nationality = this.validateStringInput("la nacionalidad",30),
            brand = this.validateStringInput("la marca del auto", 30),
            colour = this.validateStringInput("el color del auto", 30),
            model = this.validateStringInput("el modelo del auto", 30);
        Vehicle vehicle = new Vehicle(brand, colour, model);
        CarDriver carDriver = new CarDriver(driverUsername, name, vehicle, nationality);
        if(this.DBControl.addCarDriver(carDriver)){
            JOptionPane.showMessageDialog(null, "El nuevo corredor ha sido ingresado exitosamente.","Ingreso Exitoso", 0);
        } else {
            JOptionPane.showMessageDialog(null, "Error al intentar ingresar el nuevo corredor.","Error en el Ingreso", 0);
        }
    }

    public List<CarDriver> getFullListCarDrivers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean isGameFinished() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int inputRaceTrackLength() {
        int lengthKM = 0;
        while(lengthKM <= 0) {
            try {
                lengthKM = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese una cantidad entera para la distancia a recorrer (en kilometros)","Longitud de la Carrera",3));
                if(lengthKM <= 0) JOptionPane.showMessageDialog(null, "La longitud ingresada es invalida, las carreras son de minimo 1 kilometro.","Longitud invalida",2);
            } catch(NumberFormatException ex1) {
                JOptionPane.showMessageDialog(null, "Por favor ingrese una cantidad numerica entera.","Formato de Dato Incorrecto",2);
            }
        }
        return(lengthKM);
    }
    
    public int inputNumberOfDrivers() {
        int numDrivers = -1;
        while(numDrivers < 3 || numDrivers > 20) {
            try {
                numDrivers = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese la cantidad de juegadores mayor o igual que 3 y menor o igual a 20.","Cantidad de Corredores",3));
                if(numDrivers < 3) JOptionPane.showMessageDialog(null, "Numero de corredores invalido, se requieren minimo 3.","Numero de Corredores Invalido",2);
                if(numDrivers > 20) JOptionPane.showMessageDialog(null, "Numero de corredores invalido, se requieren maximo 20.","Numero de Corredores Invalido",2);
            } catch(NumberFormatException ex1) {
                JOptionPane.showMessageDialog(null, "Por favor ingrese una cantidad numerica entera.","Formato de Dato Incorrecto",2);
            }
        }
        return(numDrivers);
    }
    
    public List<TrackLane> getDriversData(int numDrivers){
        List<TrackLane> trackLanesList = new ArrayList<>();
        for(int i = 0 ; i < numDrivers ; i++){
            CarDriver driver = DBControl.getRandomDriver();
            TrackLane trackLane = new TrackLane(driver, (i + 1));
            trackLanesList.add(trackLane);
        }
        return(trackLanesList);
    }

    public void goAhead() {
        this.currentRaceTrack.goAhead();
    }

    public List<CarDriver> getDriversResultList() {
        return(null);
    }
    
}
