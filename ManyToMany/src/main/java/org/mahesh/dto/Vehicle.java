package org.mahesh.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by ADMIN on 09-11-2014.
 */
@Entity
public class Vehicle {
    @Id @GeneratedValue
    private int vehicleId;
    private String vehicleName;
    @ManyToMany(mappedBy = "vehicleList") // vehicleList should be matched with the variable in the UserDetails class
    private Collection<User> userList = new ArrayList<User>();

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

    public Collection<User> getUserDetails() {
        return userList;
    }

    public void setUserDetails(Collection<User> userDetails) {
        this.userList = userDetails;
    }
}
