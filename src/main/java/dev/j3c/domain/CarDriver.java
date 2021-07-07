
package dev.j3c.domain;

import java.util.Objects;

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
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.username);
        hash = 79 * hash + Objects.hashCode(this.name);
        hash = 79 * hash + Objects.hashCode(this.vehicle);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CarDriver other = (CarDriver) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.vehicle, other.vehicle)) {
            return false;
        }
        return true;
    }
    
    
}
