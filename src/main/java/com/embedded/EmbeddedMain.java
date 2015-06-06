package com.embedded;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;

/**
 * Created by maheshwar on 5/30/2015.
 */
public class EmbeddedMain {
    public static void main(String[] args) {
        UserDetails user1 = createUser(1);
        UserDetails user2 = createUser(2);

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user1);
        session.save(user2);
        session.getTransaction().commit();
        session.close();

        user1 = null;
        user2 = null;

        session = sessionFactory.openSession();
        user1 = (UserDetails) session.get(com.embedded.UserDetails.class, 1);
        user2 = (UserDetails) session.get(com.embedded.UserDetails.class, 2);
        System.out.println("User1 "+ user1);
        System.out.println("User2 "+ user2);
    }

    private static UserDetails createUser(final int salt ) {
        UserDetails user = new UserDetails();
        user.setUserName("First User " + salt);
        user.setHomeAddress(createAddress(salt));
        user.setOfficeAddress(createAddress(salt));
        user.setJoinedDate(new Date());
        user.setDescription("User Description " + salt);

        return user;
    }

    private static Address createAddress(final int salt ) {
        Address address = new Address();
        address.setCity("City "+ salt);
        address.setPincode("Pincode " + salt);
        address.setState("State " + salt);
        address.setStreet("Street " + salt);

        return address;
    }
}
