
package dev.j3c.domain;

public class CarDriver {
    private String username, name, nationality;
    private Vehicle vehicle; 

    public CarDriver(){
    }

    public CarDriver(String username, String name, Vehicle vehicle, String nationality) {
        this.username = username;
        this.name = name;
        this.vehicle = vehicle;
        this.nationality = nationality;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return this.nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Vehicle getVehicle() {
        return this.vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String toString() {
        return "username: " + username + ", name: " + name + ", nationality: " + nationality + '}';
    }
    
    
}
