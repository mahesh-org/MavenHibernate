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
    private UserDetails userDetails;

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

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }
}
