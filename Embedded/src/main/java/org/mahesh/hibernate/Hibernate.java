package org.mahesh.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.mahesh.dto.User;
import org.mahesh.dto.Address;

/**
 * Created by ADMIN on 09-11-2014.
 */
public class Hibernate {
    public static void main(String[] args) {

    	 User user1 = createUser(1);
         User user2 = createUser(2);

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
         user1 = (User) session.get(org.mahesh.dto.User.class, 1);
         user2 = (User) session.get(org.mahesh.dto.User.class, 2);
         System.out.println("User1 "+ user1);
         System.out.println("User2 "+ user2);

    }
    
    private static User createUser(final int salt ) {
        User user = new User();
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
