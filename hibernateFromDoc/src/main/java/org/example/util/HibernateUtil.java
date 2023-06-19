package org.example.util;


import org.hibernate.SessionFactory;

import org.hibernate.cfg.*;

/*
* Create Session Class using Singleton Pattern
* */
public class HibernateUtil {

    private static SessionFactory sessionFactory;

    public HibernateUtil(String configPath){
        try {

            if (sessionFactory == null)
                sessionFactory = new Configuration().configure(configPath).buildSessionFactory();

        }catch (Throwable throwable){
            System.out.println("Initial Session Factory error occured: " + throwable);
            throw new ExceptionInInitializerError(throwable);
        }
    }

    public SessionFactory getSessionFactory(){
        return sessionFactory;
    }


}
