package org.mahesh.dto.joined;

import javax.persistence.Entity;

/**
 * Created by maheshwar on 6/5/2015.
 */
@Entity
public class FourWheeler extends Vehicle {
    private String fourWheelerName;

    public String getFourWheelerName() {
        return fourWheelerName;
    }

    public void setFourWheelerName(String fourWheelerName) {
        this.fourWheelerName = fourWheelerName;
    }
}
