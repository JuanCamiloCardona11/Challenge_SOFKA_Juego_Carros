
package dev.j3c.domain;

public class Podium {
    private CarDriver[] listaGanadores;
    
    public Podium(){
    }
    
    public Podium(CarDriver primerPuesto, CarDriver segundoPuesto, CarDriver tercerPuesto) {
        this.listaGanadores[0] = primerPuesto;
        this.listaGanadores[1] = segundoPuesto;
        this.listaGanadores[2] = tercerPuesto;
    }

    public CarDriver[] getListaGanadores() {
        return (this.listaGanadores);
    }
    
    
}
