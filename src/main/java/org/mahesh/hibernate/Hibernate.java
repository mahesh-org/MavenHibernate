package org.mahesh.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.mahesh.dto.AddressOld2;
import org.mahesh.dto.UserDetails;
import org.mahesh.dto.UserDetailsOld2;

/**
 * Created by ADMIN on 09-11-2014.
 */
public class Hibernate {
    public static void main(String[] args) {

        UserDetails userDetails = new UserDetails();
        userDetails.setUserName("First UserDetails!");

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(userDetails);
        session.beginTransaction().commit();
        session.close();

        userDetails = null;
        session = sessionFactory.openSession();
        session.beginTransaction();
        userDetails = (UserDetails) session.get(UserDetails.class, 1);
        session.close();
        System.out.println("UserName= [" + userDetails.getUserName()+ "]");

    }
}
