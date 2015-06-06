package org.mahesh.dto.joined;

import javax.persistence.*;

/**
 * This is to demonstrate third normal form (Best one),
 * It creates all data into Vehicle (Super) table. and then Vehicle Id will be stored into sbuclass table.
 *
 * Vehicle table will have (car, two, Four wheeler VehicleId in Vehicle table) and then VehicleId will be used in Subclasses
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
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
