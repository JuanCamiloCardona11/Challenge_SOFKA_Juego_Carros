
package dev.j3c.domain;

public class TrackLane {
    private CarDriver carDriver;
    private int trackLaneNumber;
    private int finalPosition;

    public TrackLane() {
    }

    public TrackLane(CarDriver carDriver, int trackLaneNumber) {
        this.carDriver = carDriver;
        this.trackLaneNumber = trackLaneNumber;
        this.finalPosition = -1;
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

    public int getFinalPosition() {
        return this.finalPosition;
    }

    public void setFinalPosition(int finalPosition) {
        this.finalPosition = finalPosition;
    }

    
    
    @Override
    public String toString() {
        return "TrackLane{" + "carDriver=" + carDriver + '}';
    }
}
