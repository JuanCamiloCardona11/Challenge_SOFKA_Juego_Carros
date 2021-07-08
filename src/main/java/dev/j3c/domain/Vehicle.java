
package dev.j3c.domain;

import dev.j3c.helpers.RandomDistance;
import java.awt.Color;

public class Vehicle {
    private String brand;
    private String colour;    
    private String model;
    private int currentDistance;
            
    public Vehicle() {
    }
    
    public Vehicle(String brand, String colour, String model) {
        this.brand = brand;
        this.colour = colour;
        this.model = model;
        this.currentDistance = 0;
    }
    
    public void goAhead() {
        this.currentDistance += RandomDistance.getNewRandomDistance();
    }

    public String getBrand() {
        return (this.brand);
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColour() {
        return (this.colour);
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getModel() {
        return (this.model);
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCurrentDistance() {
        return (this.currentDistance);
    }
    
    @Override
    public String toString() {
        return ("Vehicle {" + "brand: " + brand + ", colour: " + colour + ", model: " + model + '}');
    }
}
