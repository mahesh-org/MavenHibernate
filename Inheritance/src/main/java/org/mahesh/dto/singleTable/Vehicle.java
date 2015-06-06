package org.mahesh.dto.singleTable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by ADMIN on 09-11-2014.
 */
//This is to demonstrate single normal form, means one primary for a table and put everything in one table
@Entity
@DiscriminatorColumn(
        name = "VEHICLE_TYPE",
        discriminatorType = DiscriminatorType.STRING
)
public class Vehicle {
    @Id @GeneratedValue
    private int vehicleId;
    private String vehicleName;

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
}
