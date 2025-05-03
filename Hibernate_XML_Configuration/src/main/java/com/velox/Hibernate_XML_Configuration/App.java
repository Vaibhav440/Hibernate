package com.velox.Hibernate_XML_Configuration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {

        // Configure Hibernate
        Configuration configuration = new Configuration();
        configuration.configure();

        // Create SessionFactory
        SessionFactory factory = configuration.buildSessionFactory();
        System.out.println("SessionFactory created: " + factory);

        // Create an Employee object
        Employee employee = new Employee(102, "Om", "Dev");

        // Open session
        Session session = null;
        Transaction transaction = null;

        try {
            session = factory.openSession();
            transaction = session.beginTransaction();

            // Save the employee
            session.save(employee);
            transaction.commit();  // Commit transaction

            // Print success message if no exceptions occur
            System.out.println("Employee saved successfully: " + employee);

        } catch (Exception e) {
            // Handle exception and rollback if any error occurs
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            // Close session and factory
            if (session != null) {
                session.close();
            }
            if (factory != null) {
                factory.close();
            }
        }
    }
}
