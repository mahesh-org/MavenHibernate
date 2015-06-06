package org.mahesh.dto.joined;

import javax.persistence.Entity;

/**
 * Created by maheshwar on 6/5/2015.
 */
@Entity
public class TwoWheeler extends Vehicle {
    private String twoWheelerName;

    public String getTwoWheelerName() {
        return twoWheelerName;
    }

    public void setTwoWheelerName(String twoWheelerName) {
        this.twoWheelerName = twoWheelerName;
    }
}
