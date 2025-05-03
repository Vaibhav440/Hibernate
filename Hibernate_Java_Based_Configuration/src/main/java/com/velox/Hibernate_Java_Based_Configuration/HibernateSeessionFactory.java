package com.velox.Hibernate_Java_Based_Configuration;

import java.util.Properties;

import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateSeessionFactory {

    private static SessionFactory sessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();

            // Hibernate settings
            Properties settings = new Properties();
            settings.put("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
            settings.put("hibernate.connection.url", "jdbc:mysql://192.168.0.190/employeemgmt?useSSL=false");
            settings.put("hibernate.connection.username", "root");
            settings.put("hibernate.connection.password", "root");
            settings.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
            settings.put("hibernate.hbm2ddl.auto", "update");
            settings.put("hibernate.show_sql", "true");

            configuration.setProperties(settings);

            // Register annotated class
            configuration.addAnnotatedClass(EmployeeTest.class);

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

            sessionFactory = (SessionFactory) configuration.buildSessionFactory(serviceRegistry);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
