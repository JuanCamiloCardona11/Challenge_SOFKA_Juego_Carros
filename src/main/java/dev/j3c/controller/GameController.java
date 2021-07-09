
package dev.j3c.controller;

import dev.j3c.domain.*;
import dev.j3c.model.DBController;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;

public class GameController {
    private RaceTrack currentRaceTrack;
    private final DBController DBControl;
    private int finalPosition; 
    
    public GameController(){
        this.DBControl = new DBController();
        this.finalPosition = 0;
    }
     
    public RaceTrack getCurrentRaceTrack() {
        return this.currentRaceTrack;
    }

    public void setCurrentRaceTrack(RaceTrack newRaceTrack) {
        this.currentRaceTrack = newRaceTrack;
        this.finalPosition = 0;
    }
    
    public List<CarDriver> getFullListCarDrivers() {
        List<CarDriver> carDriversList = this.DBControl.getFullListCarDrivers();
        return(carDriversList);
    }
    
    public List<Podium> getFullListPodiums() {
        List<Podium> podiumsList = this.DBControl.getFullListPodiums();
        return(podiumsList);
    }

    public boolean validateNewUsername(String driverUsername) {
        boolean validUsername = false;
        if(driverUsername.matches("^[a-z0-9_-]{3,50}$")){
            if(!this.DBControl.driverExists(driverUsername)){
                validUsername = true;
            } else {
                JOptionPane.showMessageDialog(null, "El corredor con nombre de usuario: " + driverUsername + " ya se encuentra registrado en el sistema, intente con uno nuevo la siguiente vez.","Nombre de Usuario Existente.",0);
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
            JOptionPane.showMessageDialog(null, "El nuevo corredor ha sido ingresado exitosamente.","Ingreso Exitoso", 1);
        } else {
            JOptionPane.showMessageDialog(null, "Error al intentar ingresar el nuevo corredor.","Error en el Ingreso", 0);
        }
    }

    public int inputRaceTrackLength() {
        int lengthKM = 0;
        while(lengthKM <= 0) {
            try {
                lengthKM = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese una cantidad entera para la distancia a recorrer (en kilometros)","Longitud de la Carrera",3));
                if(lengthKM <= 0) JOptionPane.showMessageDialog(null, "La longitud ingresada es invalida, las carreras son de minimo 1 kilometro.","Longitud invalida",2);
            } catch(NumberFormatException ex1) {
                JOptionPane.showMessageDialog(null, "Por favor ingrese una cantidad numerica entera.","Formato de Dato Incorrecto",0);
            }
        }
        return(lengthKM * 1000);
    }
    
    public int inputNumberOfDrivers() {
        int numDrivers = -1;
        while(numDrivers < 3 || numDrivers > this.DBControl.getNumberOfDrivers()) {
            try {
                numDrivers = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese la cantidad de juegadores mayor o igual que 3 y menor o igual a " + this.DBControl.getNumberOfDrivers() + ": ","Cantidad de Corredores",3));
                if(numDrivers < 3) JOptionPane.showMessageDialog(null, "Numero de corredores invalido, se requieren minimo 3.","Numero de Corredores Invalido",2);
                if(numDrivers > 20) JOptionPane.showMessageDialog(null, "Numero de corredores invalido, se requieren maximo " + this.DBControl.getNumberOfDrivers(),"Numero de Corredores Invalido",2);
            } catch(NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Por favor ingrese una cantidad numerica entera.","Formato de Dato Incorrecto",0);
            }
        }
        return(numDrivers);
    }
    
    private List<TrackLane> assignTrackLane(Set<CarDriver> carDriverSet) {
        List<TrackLane> trackLaneList = new ArrayList<>();
        int trackLaneNumber = 1;
        for(CarDriver carDriver : carDriverSet){
            TrackLane trackLane = new TrackLane(carDriver, trackLaneNumber++);
            trackLaneList.add(trackLane);
        }
        return(trackLaneList);
    }
    
    private boolean driverIsSelected(String driverUsername, Set<CarDriver> carDriversSet){
        boolean driverSelected = false;
        for(CarDriver carDriver : carDriversSet) {
            if(carDriver.getUsername().equals(driverUsername)) {
                driverSelected = true;
                break;
            }
        }
        return(driverSelected);
    }
    
    public List<TrackLane> getDriversData(int numDrivers){
        Set<CarDriver> carDriversSet = new HashSet<>();
        while(carDriversSet.size() < numDrivers) {
            CarDriver driver = DBControl.getRandomDriver();
            if(!this.driverIsSelected(driver.getUsername(), carDriversSet)) {
                carDriversSet.add(driver);
            }
        }
        return(this.assignTrackLane(carDriversSet));
    }

    private boolean isArrivalRegistred(TrackLane theTrackLane) {
        boolean registred = false;
        if(theTrackLane.getFinalPosition() != -1){
            registred = true;
        }
        return(registred);
    }
    
    public void goAhead() {
        for(TrackLane trackLane : this.currentRaceTrack.getTrackLanesList()) {
            if(trackLane.getCarDriver().getVehicle().getCurrentDistance() < this.currentRaceTrack.getTrackLanesLength()){
                trackLane.getCarDriver().getVehicle().goAhead();    //Si no ha terminado, avanza
            } else if(!this.isArrivalRegistred(trackLane)) {         //Si ya termino y no esta registrado, se registra la posicion de llegada.
                trackLane.setFinalPosition(this.finalPosition++);    
            }
        }
    }
    
    public boolean isGameFinished() {
        boolean gameFinished = true;
        for(TrackLane trackLane : this.currentRaceTrack.getTrackLanesList()){
            if(trackLane.getFinalPosition() == -1) {
                gameFinished = false;
                break;
            }
        }
        return(gameFinished);
    }

    private CarDriver getDriverByFinalPosition(int finalPosition){
        CarDriver carDriver = null;
        for(TrackLane trackLane : this.currentRaceTrack.getTrackLanesList()){
            if(trackLane.getFinalPosition() == finalPosition) {
                carDriver = trackLane.getCarDriver();
            }
        }
        return (carDriver);
    }
    
    public boolean constructCurrentPodium() {
        boolean podiumRegistred = false;
        CarDriver firstPositionDriver = this.getDriverByFinalPosition(0);
        CarDriver secondPositionDriver = this.getDriverByFinalPosition(1);
        CarDriver thirdPositionDriver = this.getDriverByFinalPosition(2);
        int raceLength = this.currentRaceTrack.getTrackLanesLength();
        if(this.DBControl.addNewPodium(firstPositionDriver, secondPositionDriver, thirdPositionDriver, raceLength)){
            podiumRegistred = true;
        }
        return(podiumRegistred);
    }

    public void resetCurrentGame() {
        for(TrackLane trackLane: this.currentRaceTrack.getTrackLanesList()) {
            trackLane.getCarDriver().getVehicle().setCurrentDistance(0);
            trackLane.setFinalPosition(-1);
        }
    }
}
