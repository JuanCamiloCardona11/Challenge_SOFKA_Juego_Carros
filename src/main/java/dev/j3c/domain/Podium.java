
package dev.j3c.domain;

public class Podium {
    private CarDriver[] listaGanadores;
    private int raceLength;
    
    public Podium(){
    }
    
    public Podium(CarDriver primerPuesto, CarDriver segundoPuesto, CarDriver tercerPuesto, int raceLength) {
        listaGanadores = new CarDriver[3];
        this.listaGanadores[0] = primerPuesto;
        this.listaGanadores[1] = segundoPuesto;
        this.listaGanadores[2] = tercerPuesto;
        this.raceLength = raceLength;
    }

    public CarDriver[] getListaGanadores() {
        return (this.listaGanadores);
    }

    public int getRaceLength() {
        return raceLength;
    }
}
