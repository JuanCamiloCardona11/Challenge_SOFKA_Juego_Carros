
package dev.j3c.domain;

public class CarDriver {
    private String username, name;
    private Vehicle vehicle; 

    public CarDriver(){
    }

    public CarDriver(String username, String name, Vehicle vehicle) {
        this.username = username;
        this.name = name;
        this.vehicle = vehicle;
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

    public Vehicle getVehicle() {
        return this.vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
    
    @Override
    public String toString() {
        return ("CarDriver {" + "username: " + username + ", name: " + name + ", vehicle: " + vehicle + '}');
    }
}
