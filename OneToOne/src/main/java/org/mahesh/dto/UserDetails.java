package org.mahesh.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Created by ADMIN on 09-11-2014.
 */
@Entity
@Table (name = "USER_DETAILS")
public class UserDetails {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int userId;
    private String userName;
    @OneToOne // This wil create a new column in user_details table with a column 'vehicle_id'
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

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

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
