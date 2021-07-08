
package dev.j3c.domain;

import java.util.List;
import dev.j3c.domain.TrackLane;

public class RaceTrack {
    private int trackLanesLength;
    private List<TrackLane> trackLanesList;

    public RaceTrack() {
    }

    public RaceTrack(int trackLanesLength, List<TrackLane> trackLanesList) {
        this.trackLanesLength = trackLanesLength;
        this.trackLanesList = trackLanesList;
    }

    public int getTrackLanesLength() {
        return (this.trackLanesLength);
    }

    public List<TrackLane> getTrackLanesList() {
        return (this.trackLanesList);
    }

    public void goAhead() {
        this.trackLanesList.forEach((trackLane) -> {
            trackLane.getCarDriver().getVehicle().goAhead();
        });
    }

    public boolean juegoTerminado() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
