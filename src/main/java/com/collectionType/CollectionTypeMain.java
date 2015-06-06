package com.collectionType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.*;

/**
 * Created by maheshwar on 5/30/2015.
 */
public class CollectionTypeMain {
    private static final int ID_1 = 1;
    private static final int ID_2 = 2;

    public static void main(String[] args) {
        UserDetails user1 = createUser(ID_1);
        UserDetails user2 = createUser(ID_2);

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
        user1 = (UserDetails) session.get(UserDetails.class, ID_1);
        user2 = (UserDetails) session.get(UserDetails.class, ID_2);

        System.out.println("User1 " + user1);
        //session.close(); //-- even the the session is closed, if its Eager we are going to get the result
        System.out.println("User1 Address Size " + user1.getListOfAddress().size());
        System.out.println("User2 " + user2);
    }

    private static UserDetails createUser(final int salt ) {
        UserDetails user = new UserDetails();
        user.setUserName("First User " + salt);
        user.setListOfAddress(createAddress());
        user.setJoinedDate(new Date());
        user.setDescription("User Description " + salt);

        return user;
    }

    private static Set<Address> createAddress() {
        Set<Address> addresses = new HashSet<Address>();
        addresses.add(createAddress(ID_1));
        addresses.add(createAddress(ID_2));
        return addresses;
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
