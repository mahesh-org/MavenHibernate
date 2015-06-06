package org.mahesh.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Created by ADMIN on 09-11-2014.
 */
@Entity
public class Vehicle {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int vehicleId;
    private String vehicleName;

    // 1) If you simply put this @ManyToOne, it again creates a new column in Vehicle
    //@ManyToOne

    // 2) this is for in creating a new column in USER_ID the same table
    /*@ManyToOne
    @JoinColumn(name = "USER_ID")*/

    // 3) One more way without mappedBy
    @ManyToOne
    @JoinColumn(name = "USER_ID")
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
