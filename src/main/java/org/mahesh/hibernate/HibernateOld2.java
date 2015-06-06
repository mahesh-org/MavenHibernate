package org.mahesh.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.mahesh.dto.AddressOld2;
import org.mahesh.dto.UserDetailsOld2;

/**
 * Created by ADMIN on 09-11-2014.
 */
public class HibernateOld2 {
    public static void main(String[] args) {

        UserDetailsOld2 userDetails = new UserDetailsOld2();
        userDetails.setUserName("First UserDetailsOld2!");

        AddressOld2 homeAddressOld2 = new AddressOld2();
        homeAddressOld2.setStreet("Home Street Name");
        homeAddressOld2.setCity("Home City Name");
        homeAddressOld2.setState("Home State Name");

        AddressOld2 officeAddressOld2 = new AddressOld2();
        officeAddressOld2.setStreet("Street Name");
        officeAddressOld2.setCity("City Name");
        officeAddressOld2.setState("State Name");

        userDetails.getListOfAddreses().add(homeAddressOld2);
        userDetails.getListOfAddreses().add(officeAddressOld2);


        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(userDetails);
        session.beginTransaction().commit();
        session.close();

        userDetails = null;
        session = sessionFactory.openSession();
        session.beginTransaction();
        userDetails = (UserDetailsOld2) session.get(UserDetailsOld2.class, 1);
        session.close();
        System.out.println("Size = [" + userDetails.getListOfAddreses().size()+ "]");

    }
}
