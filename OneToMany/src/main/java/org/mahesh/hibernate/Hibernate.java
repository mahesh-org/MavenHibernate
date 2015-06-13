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

        User user = new User();
        user.setUserName("First UserDetails!");

        Vehicle vehicleCar = new Vehicle();
        vehicleCar.setVehicleName("Car");

        Vehicle vehicleJeep = new Vehicle();
        vehicleJeep.setVehicleName("Jeep");

        //One to many relationship
        user.getVehicle().add(vehicleCar);
        user.getVehicle().add(vehicleJeep);

        //Many to one relationship
        vehicleCar.setUser(user);
        vehicleJeep.setUser(user);

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.save(vehicleCar);
        session.save(vehicleJeep);
        session.beginTransaction().commit();
        session.close();

    }
}
