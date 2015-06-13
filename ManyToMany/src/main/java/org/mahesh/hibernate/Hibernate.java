package org.mahesh.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.mahesh.dto.User;
import org.mahesh.dto.Vehicle;

/**
 * Created by ADMIN on 09-11-2014.
 */
public class Hibernate {
    public static void main(String[] args) {

        User userDetails = new User();
        userDetails.setUserName("First UserDetails!");

        Vehicle vehicleCar = new Vehicle();
        vehicleCar.setVehicleName("Car");

        Vehicle vehicleJeep = new Vehicle();
        vehicleJeep.setVehicleName("Jeep");

        //Many to many relationship
        userDetails.getVehicle().add(vehicleCar);
        userDetails.getVehicle().add(vehicleJeep);

        //Many to Many relationship
        vehicleCar.getUserDetails().add(userDetails);
        vehicleJeep.getUserDetails().add(userDetails);

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(userDetails);
        session.save(vehicleCar);
        session.save(vehicleJeep);
        session.beginTransaction().commit();
        session.close();

    }
}
