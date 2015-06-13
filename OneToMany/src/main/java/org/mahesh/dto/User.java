package org.mahesh.dto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by ADMIN on 09-11-2014.
 */
@Entity
@Table (name = "USER")
public class User {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    //@Column(name = "USER_ID")
    private int userId;
    private String userName;
    // 1) This will create a new colume with both user and vehicle id and with joinTable option
    /*@OneToMany
    @JoinTable(name = "USER_VEHICLE", joinColumns = @JoinColumn(name = "USER_ID"),
                inverseJoinColumns = @JoinColumn(name = "VEHICLE_ID"))*/
    // 2) Adding a new column to vehicle table rather than a new table
    /*@OneToMany(mappedBy = "user")*/

    // 3) One more way without mappedBy (if you comment vehicle its creates a column in Vehicle table)
    @OneToMany
    @JoinColumn(name = "user_Id")
    private Collection<Vehicle> vehicle = new ArrayList<Vehicle>();

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
        return vehicle;
    }

    public void setVehicle(Collection<Vehicle> vehicle) {
        this.vehicle = vehicle;
    }
}
