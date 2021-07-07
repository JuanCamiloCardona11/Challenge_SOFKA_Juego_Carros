/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.j3c.domain;

/**
 *
 * @author administrator
 */
public class TrackLane {
    private CarDriver carDriver;
    private int trackLaneNumber;

    public TrackLane() {
    }

    public TrackLane(CarDriver carDriver, int trackLaneNumber) {
        this.carDriver = carDriver;
        this.trackLaneNumber = trackLaneNumber;
    }

    public CarDriver getCarDriver() {
        return carDriver;
    }

    public void setCarDriver(CarDriver carDriver) {
        this.carDriver = carDriver;
    }

    public int getTrackLaneNumber() {
        return (this.trackLaneNumber);
    }

    @Override
    public String toString() {
        return "TrackLane{" + "carDriver=" + carDriver + '}';
    }
    
    
}
