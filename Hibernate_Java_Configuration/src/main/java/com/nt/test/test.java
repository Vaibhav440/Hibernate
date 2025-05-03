package com.nt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;



public class test {

    public static void main(String[] args) {
        SessionFactory factory = HibernateConfig.getSessionFactory();
        Session session = null;
        Transaction tx = null;

        try {
            session = factory.openSession();
            tx = session.beginTransaction();

            EmployeeTest employee = new EmployeeTest(106, "Om");
            session.persist(employee);

            tx.commit();
            System.out.println("Employee saved successfully.");

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
            if (factory != null) factory.close();
        }
    }
}
