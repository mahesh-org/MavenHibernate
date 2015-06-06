package org.mahesh.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.mahesh.dto.User;

/**
 * Created by ADMIN on 09-11-2014.
 */
public class Hibernate {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        for(int i = 0; i<5; i++) {
            User user = new User();
            user.setUserName("User "+ i);
            session.save(user);
        }
        session.beginTransaction().commit();
        session.close();

        User user = null;
        session = sessionFactory.openSession();
        session.beginTransaction();
        user = (User) session.get(User.class, 3);
        session.delete(user);
        session.beginTransaction().commit();
        session.close();
    }
}
