package org.mahesh.dto.tablePerClass;

import javax.persistence.*;

/**
 * This is to demonstrate second normal form,
 * Primary and forgien key concept.
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Vehicle {
    @Id @GeneratedValue(strategy = GenerationType.TABLE)
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
