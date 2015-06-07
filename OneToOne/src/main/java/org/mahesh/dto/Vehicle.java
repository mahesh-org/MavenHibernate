package org.mahesh.dto;

import javax.persistence.*;

/**
 * Created by ADMIN on 09-11-2014.
 */
@Entity
public class Vehicle {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int vehicleId;
    private String vehicleName;

    @OneToOne
    private User user;

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
