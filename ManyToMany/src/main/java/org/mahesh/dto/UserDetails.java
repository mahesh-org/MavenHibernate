package org.mahesh.dto;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by ADMIN on 09-11-2014.
 */
@Entity
@Table (name = "USER_DETAILS")
public class UserDetails {
    @Id @GeneratedValue (strategy = GenerationType.AUTO)
    private int userId;
    private String userName;
    @ManyToMany
    //@NotFound (action = NotFoundAction.IGNORE) // When there is not data, this prevent not to through any exception saying no data found exception
    @JoinTable(name = "USER_VEHICLE", joinColumns = @JoinColumn(name = "USER_ID") ,
                inverseJoinColumns = @JoinColumn(name = "VEHICLE_ID"))
    private Collection<Vehicle> vehicleList = new ArrayList<Vehicle>();

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Collection<Vehicle> getVehicle() {
        return vehicleList;
    }

    public void setVehicle(Collection<Vehicle> vehicle) {
        this.vehicleList = vehicle;
    }
}
