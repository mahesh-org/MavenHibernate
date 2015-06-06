package org.mahesh.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.mahesh.dto.AddressOld2;
import org.mahesh.dto.UserDetailsOld1;

/**
 * Created by ADMIN on 07-11-2014.
 */
public class HibernateOld1 {
    public static void main(String[] args) {
        UserDetailsOld1 userDetailsOld = new UserDetailsOld1();
        userDetailsOld.setUsername("First UserDetailsOld1!");
        /*userDetailsOld.setAddress("First user address");
        userDetailsOld.setJoinedDate(new Date());
        userDetailsOld.setDescription("Description of the user goes here");*/

        UserDetailsOld1 userDetailsOld1 = new UserDetailsOld1();
        userDetailsOld1.setUsername("Second UserDetailsOld1!");

        AddressOld2 homeAddressOld2 = new AddressOld2();
        homeAddressOld2.setStreet("Home Street Name");
        homeAddressOld2.setCity("Home City Name");
        homeAddressOld2.setState("Home State Name");
        userDetailsOld1.setHomeAddressOld2(homeAddressOld2);

        AddressOld2 officeAddressOld2 = new AddressOld2();
        officeAddressOld2.setStreet("Street Name");
        officeAddressOld2.setCity("City Name");
        officeAddressOld2.setState("State Name");
        userDetailsOld1.setOfficeAddressOld2(homeAddressOld2);

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(userDetailsOld);
        session.save(userDetailsOld1);
        session.beginTransaction().commit();
        session.close();

        /*userDetailsOld = null;
        session = sessionFactory.openSession();
        session.beginTransaction();
        userDetailsOld = (UserDetailsOld1) session.get(UserDetailsOld1.class, 1);
        System.out.println("UserName = [" + userDetailsOld.getUsername()+ "]");*/
    }
}
