
package dev.j3c.domain;

import java.util.List;
import dev.j3c.domain.TrackLane;

public class RaceTrack {
    private int trackLength;
    private List<TrackLane> listaCarriles;

    public RaceTrack() {
    }

    public RaceTrack(int trackLength, List<TrackLane> listaCarriles) {
        this.trackLength = trackLength;
        this.listaCarriles = listaCarriles;
    }

    public int getTrackLength() {
        return (this.trackLength);
    }

    public List<TrackLane> getListaCarriles() {
        return (this.listaCarriles);
    }
}
