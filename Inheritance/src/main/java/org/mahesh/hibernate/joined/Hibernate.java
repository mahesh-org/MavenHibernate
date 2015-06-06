package org.mahesh.hibernate.joined;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.mahesh.dto.joined.FourWheeler;
import org.mahesh.dto.joined.TwoWheeler;
import org.mahesh.dto.joined.Vehicle;

/**
 * Created by ADMIN on 09-11-2014.
 */
public class Hibernate {
    public static void main(String[] args) {

        Vehicle vehicleCar = new Vehicle();
        vehicleCar.setVehicleName("Car");

        TwoWheeler twoWheeler = new TwoWheeler();
        twoWheeler.setVehicleName("Bike");
        twoWheeler.setTwoWheelerName("Pulsar");

        FourWheeler fourWheeler = new FourWheeler();
        fourWheeler.setVehicleName("Maruthi");
        fourWheeler.setFourWheelerName("Swift");


        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(vehicleCar);
        session.save(twoWheeler);
        session.save(fourWheeler);
        session.beginTransaction().commit();
        session.close();

    }
}
