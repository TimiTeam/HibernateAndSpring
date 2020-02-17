package com.gmail.timurworkspace.util;

import com.gmail.timurworkspace.entity.User;
import com.gmail.timurworkspace.entity.documentPassport.Passport;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory(){
        if (sessionFactory == null){
            sessionFactory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(User.class)
                    .addAnnotatedClass(Passport.class)
                    .buildSessionFactory();
        }
        return sessionFactory;
    }

    public static void closeSessionFactory(){
        if(sessionFactory != null){
            sessionFactory.close();
        }
    }
}
